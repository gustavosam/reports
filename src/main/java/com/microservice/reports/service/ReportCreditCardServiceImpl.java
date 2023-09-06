package com.microservice.reports.service;

import com.microservice.reports.document.ReportCardDocument;
import com.microservice.reports.model.DailyAmounts;
import com.microservice.reports.model.ReportCard;
import com.microservice.reports.repository.ReportCardRepository;
import com.microservice.reports.service.mapper.Mappers;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase implementa la interfaz ReportCreditCardService.
 *
 * */
@Service
public class ReportCreditCardServiceImpl implements ReportCreditCardService {

  @Autowired
  private ReportCardRepository reportCardRepository;


  /**
   * El método getReportCard, obtendrá la lista de saldos
   * de una tarjeta un cliente y una fecha en específico
   * Se obtendrá una lista de todos los saldos de la tarjeta del cliente en un mes específico.
   * Se calculará el saldo promedio de la tarjeta del cliente durante la fecha específica.
   * Se muestra todo el reporte al cliente.
   * */
  @Override
  public ReportCard getReportCard(String cardNumber, String document, String date) {

    List<ReportCardDocument> cardDocumentList = reportCardRepository
            .findByCardNumberAndClientDocumentAndDateStartingWith(cardNumber, document, date);

    List<DailyAmounts> dailyAmounts = cardDocumentList
            .stream()
            .map(Mappers::mapRecordCardDoctoDailyAmounts)
            .collect(Collectors.toList());

    OptionalDouble average = cardDocumentList
            .stream()
            .mapToDouble(ReportCardDocument::getCardAmount).average();

    ReportCard reportCard = new ReportCard();

    reportCard.setCardNumber(cardNumber);
    reportCard.setClient(document);
    reportCard.setAverageAmount(average.getAsDouble());
    reportCard.setDailyAmounts(dailyAmounts);

    return reportCard;
  }
}
