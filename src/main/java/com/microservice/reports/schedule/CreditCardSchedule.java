package com.microservice.reports.schedule;

import com.microservice.reports.document.ReportCardDocument;
import com.microservice.reports.document.cards.CreditCardDocument;
import com.microservice.reports.repository.ReportCardRepository;
import com.microservice.reports.service.cards.CreditCardService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Esta clase contiene un método que se ejecutará cada 24 horas.
 * */
@Service
public class CreditCardSchedule {

  @Autowired
  private CreditCardService creditCardService;

  @Autowired
  private ReportCardRepository reportCardRepository;

  /**
   * El método obtendrá información de todas las tarjetas al cierre del día
   * Se obtendrá información de los saldos de todas las tarjetas al cierre del día.
   * Dicha información será guardada todos los días en una colección que almacenará
   * el número de tarjeta, la fecha del día, el saldo disponible de la tarjeta en ese día.
   * */
  @Scheduled(fixedRate = 600000)
  public Mono<Void> executeAccounts() {

    LocalDate localDate = LocalDate.now();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    String dateFormat = localDate.format(formatter);

    Flux<CreditCardDocument> listCards = creditCardService.getAllCards();

    listCards
            .filter(Objects::nonNull)
            .map(cards -> {
              ReportCardDocument reportCardDocument = new ReportCardDocument();
              reportCardDocument.setCardNumber(cards.getCardNumber());
              reportCardDocument.setCardAmount(cards.getAvailable());
              reportCardDocument.setClientDocument(cards.getClientDocument());
              reportCardDocument.setDate(dateFormat);
              return reportCardDocument;
            })
            .flatMap(reportCardRepository::save)
            .then()
            .subscribe();

    return Mono.empty();

  }
}
