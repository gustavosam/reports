package com.microservice.reports.delegate;

import com.microservice.reports.api.ReportApiDelegate;
import com.microservice.reports.model.Movements;
import com.microservice.reports.model.ReportAccount;
import com.microservice.reports.model.ReportCard;
import com.microservice.reports.service.ReportAccountService;
import com.microservice.reports.service.ReportCreditCardService;
import com.microservice.reports.service.ReportMovementsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Esta clase implementa los métodos generados por Open Api.
 * */
@Service
public class ReportsDelegateImpl implements ReportApiDelegate {

  @Autowired
  private ReportCreditCardService reportCreditCardService;

  @Autowired
  private ReportAccountService reportAccountService;

  @Autowired
  private ReportMovementsService reportMovementsService;

  @Override
  public ResponseEntity<ReportCard> getReportCard(String cardNumber,
                                                  String document,
                                                  String date) {


    return ResponseEntity.ok(reportCreditCardService.getReportCard(cardNumber, document, date));
  }

  @Override
  public ResponseEntity<ReportAccount> getReportAccount(String accountNumber,
                                                        String document,
                                                        String date) {

    return ResponseEntity.ok(reportAccountService.getReportAccount(accountNumber, document, date));
  }

  @Override
  public ResponseEntity<List<Movements>> getCommission(String date) {

    return ResponseEntity.ok(reportMovementsService.getAllMovements(date));
  }
}
