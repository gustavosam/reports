package com.microservice.reports.service;

import com.microservice.reports.document.ReportAccountDocument;
import com.microservice.reports.document.ReportCardDocument;
import com.microservice.reports.model.DailyAmounts;
import com.microservice.reports.model.ReportAccount;
import com.microservice.reports.model.ReportCard;
import com.microservice.reports.repository.ReportCardRepository;
import com.microservice.reports.service.mapper.Mapper;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Esta clase implementa la interfaz ReportCreditCardService.
 *
 * */
@Service
public class ReportCreditCardServiceImpl implements ReportCreditCardService {

  @Autowired
  private ReportCardRepository reportCardRepository;

  @Autowired
  private Mapper mapper;


  /**
   * El método getReportCard, obtendrá la lista de saldos
   * de una tarjeta un cliente y una fecha en específico
   * Se obtendrá una lista de todos los saldos de la tarjeta del cliente en un mes específico.
   * Se calculará el saldo promedio de la tarjeta del cliente durante la fecha específica.
   * Se muestra todo el reporte al cliente.
   */
  @Override
  public Mono<ReportCard> getReportCard(String cardNumber, String document, String date) {

    Flux<ReportCardDocument> cardDocumentFlux = reportCardRepository
            .findByCardNumberAndClientDocumentAndDateStartingWith(cardNumber, document, date);

    Flux<DailyAmounts> dailyAmounts = cardDocumentFlux
            .map(card -> mapper.mapRecordCardDoctoDailyAmounts(card));

    Mono<Double> average = cardDocumentFlux
            .map(ReportCardDocument::getCardAmount)
            .reduce(Double::sum)
            .flatMap(totalAverage -> cardDocumentFlux.count().map(count -> totalAverage / count));

    Mono<List<DailyAmounts>> monoListDailyAmount = dailyAmounts.collectList();


    return monoListDailyAmount.zipWith(average).map(tuple -> {
      List<DailyAmounts> dailyAmountsList = tuple.getT1();
      Double averageAmount = tuple.getT2();

      ReportCard reportCard = new ReportCard();
      reportCard.setCardNumber(cardNumber);
      reportCard.setClient(document);
      reportCard.setAverageAmount(averageAmount);
      reportCard.setDailyAmounts(dailyAmountsList);

      return reportCard;
    });



  }
}
