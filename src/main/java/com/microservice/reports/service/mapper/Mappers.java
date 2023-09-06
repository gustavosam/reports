package com.microservice.reports.service.mapper;

import com.microservice.reports.document.ReportAccountDocument;
import com.microservice.reports.document.ReportCardDocument;
import com.microservice.reports.document.cards.CreditCardDocument;
import com.microservice.reports.document.movements.MovementsDocuments;
import com.microservice.reports.model.DailyAmounts;
import com.microservice.reports.model.Movements;

/**
 * Esta clase contiene métodos que convertirán una clase a otra.
 * */

public class Mappers {

  /**
   * Este método convierte la clase ReportCardDocument a DailyAmmounts.
   * */
  public static DailyAmounts mapRecordCardDoctoDailyAmounts(ReportCardDocument reportCardDocument) {
    DailyAmounts dailyAmounts = new DailyAmounts();

    dailyAmounts.setAmount(reportCardDocument.getCardAmount());
    dailyAmounts.setDate(reportCardDocument.getDate());

    return dailyAmounts;

  }

  /**
   * Este método convierte ReportAccountDocument en DailyAmmounts.
   * */
  public static DailyAmounts mapRecordAccountDoctoDailyAmounts(ReportAccountDocument
                                                                       reportCardDocument) {
    DailyAmounts dailyAmounts = new DailyAmounts();

    dailyAmounts.setAmount(reportCardDocument.getAccountAmount());
    dailyAmounts.setDate(reportCardDocument.getDate());

    return dailyAmounts;
  }

  /**
   * Este método convierte MovementsDocuments en Movements.
   * */

  public static Movements mapMovementDocToMovements(MovementsDocuments movementsDocuments) {
    Movements movements = new Movements();
    movements.setMovementNumber(movementsDocuments.getMovementNumber());
    movements.setMovementType(movementsDocuments.getMovementType());
    movements.setClientDocument(movementsDocuments.getClientDocument());
    movements.setAccountType(movementsDocuments.getAccountType());
    movements.setAccountNumber(movementsDocuments.getMovementNumber());
    movements.setAmount(movementsDocuments.getAmount());
    movements.setCommission(movementsDocuments.getCommission());
    movements.setMovementDate(movementsDocuments.getMovementDate());

    return movements;
  }
}
