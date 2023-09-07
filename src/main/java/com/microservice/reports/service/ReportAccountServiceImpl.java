package com.microservice.reports.service;

import com.microservice.reports.document.ReportAccountDocument;
import com.microservice.reports.model.DailyAmounts;
import com.microservice.reports.model.ReportAccount;
import com.microservice.reports.repository.ReportAccountRepository;
import com.microservice.reports.service.mapper.Mapper;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
  public ReportAccount getReportAccount(String accountNumber, String document, String date) {
    List<ReportAccountDocument> cardDocumentList = reportAccountRepository
            .findByAccountNumberAndClientDocumentAndDateStartingWith(accountNumber, document, date);

    List<DailyAmounts> dailyAmounts = cardDocumentList
            .stream()
            .map(account -> mapper.mapRecordAccountDoctoDailyAmounts(account))
            .collect(Collectors.toList());

    OptionalDouble average = cardDocumentList
            .stream()
            .mapToDouble(ReportAccountDocument::getAccountAmount)
            .average();

    ReportAccount reportAccount = new ReportAccount();

    reportAccount.setAccountNumber(accountNumber);
    reportAccount.setClient(document);
    reportAccount.setAverageAmount(average.getAsDouble());
    reportAccount.setDailyAmounts(dailyAmounts);

    return reportAccount;
  }
}
