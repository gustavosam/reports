package com.microservice.reports.delegate;

import com.microservice.reports.api.ReportApiDelegate;
import com.microservice.reports.model.Movements;
import com.microservice.reports.model.ReportAccount;
import com.microservice.reports.model.ReportCard;
import com.microservice.reports.service.ReportAccountService;
import com.microservice.reports.service.ReportCreditCardService;
import com.microservice.reports.service.ReportMovementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
  public Mono<ResponseEntity<ReportCard>> getReportCard(String cardNumber,
                                                        String document,
                                                        String date,
                                                        ServerWebExchange exchange) {

    return reportCreditCardService.getReportCard(cardNumber, document, date)
            .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<ReportAccount>> getReportAccount(String accountNumber,
                                                              String document,
                                                              String date,
                                                              ServerWebExchange exchange) {

    return reportAccountService.getReportAccount(accountNumber, document, date)
            .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<Flux<Movements>>> getCommission(String date,
                                                             ServerWebExchange exchange) {

    return Mono.just(ResponseEntity.ok(reportMovementsService.getAllMovements(date)));
  }
}
