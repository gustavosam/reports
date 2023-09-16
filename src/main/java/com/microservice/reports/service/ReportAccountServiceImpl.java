package com.microservice.reports.service;

import com.microservice.reports.document.ReportAccountDocument;
import com.microservice.reports.model.DailyAmounts;
import com.microservice.reports.model.ReportAccount;
import com.microservice.reports.repository.ReportAccountRepository;
import com.microservice.reports.service.mapper.Mapper;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Esta clase implementa la interfaz ReportAccountService.
 *
 * */
@Service
public class ReportAccountServiceImpl implements ReportAccountService {

  @Autowired
  private ReportAccountRepository reportAccountRepository;

  @Autowired
  private Mapper mapper;

  /**
   * El método getReportAccount, devolverá una lista con los saldos de una cuenta de
   * un cliente en un año y mes específicos.
   * Se generará una lista con el saldo y fecha de esa cuenta.
   * Se calculará el saldo promedio de la cuenta.
   * Se guardará toda esa información y se le mostrará al cliente como reporte.
   * */
  @Override
  public Mono<ReportAccount> getReportAccount(String accountNumber, String document, String date) {


    Flux<ReportAccountDocument> accountDocumentFlux = reportAccountRepository
            .findByAccountNumberAndClientDocumentAndDateStartingWith(accountNumber, document, date);

    Flux<DailyAmounts> dailyAmounts = accountDocumentFlux
            .map(account -> mapper.mapRecordAccountDoctoDailyAmounts(account));

    Mono<Double> average = accountDocumentFlux
            .map(ReportAccountDocument::getAccountAmount)
            .reduce(Double::sum)
            .flatMap(totalAverage -> accountDocumentFlux.count().map(count -> totalAverage / count));

    Mono<List<DailyAmounts>> monoListDailyAmounts = dailyAmounts.collectList();

    return monoListDailyAmounts.zipWith(average).map(tuple ->{

      List<DailyAmounts> dailyAmountsList = tuple.getT1();
      Double averageAmount = tuple.getT2();

      ReportAccount reportAccount = new ReportAccount();

      reportAccount.setAccountNumber(accountNumber);
      reportAccount.setClient(document);
      reportAccount.setAverageAmount(averageAmount);
      reportAccount.setDailyAmounts(dailyAmountsList);

      return reportAccount;

    });


  }
}
