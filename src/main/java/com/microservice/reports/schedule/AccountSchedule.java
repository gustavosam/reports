package com.microservice.reports.schedule;

import com.microservice.reports.document.ReportAccountDocument;
import com.microservice.reports.document.accounts.AccountsDocuments;
import com.microservice.reports.repository.ReportAccountRepository;
import com.microservice.reports.service.account.AccountService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Esta clase que hará es obtener los saldos diarios de todas las cuentas
 * Y guardarlas en una nueva colección con el saldo que tenga la cuenta
 * al cierre del día.
 * */
@Service
public class AccountSchedule {

  @Autowired
  private AccountService accountService;

  @Autowired
  private ReportAccountRepository reportAccountRepository;


  /**
   * Este método se ejecutará cada 24 horas
   * Tomará todos los datos de la cuenta al cierre del día (saldos)
   * y los guardará en una nueva colección para luego consultar los saldos
   * diarios de la cuenta y calcular su saldo promedio.
   * */
  @Scheduled(fixedRate = 86400000)
  public void executeAccounts() {

    LocalDate localDate = LocalDate.now();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    String dateFormat = localDate.format(formatter);

    List<AccountsDocuments> listAccounts = accountService.getAllAccounts();

    List<ReportAccountDocument> listReportCardDocuments = listAccounts
            .stream()
            .filter(Objects::nonNull)
            .map(account -> {
              ReportAccountDocument reportAccount = new ReportAccountDocument();
              reportAccount.setAccountNumber(account.getAccountNumber());
              reportAccount.setAccountAmount(account.getAccountAmount());
              reportAccount.setClientDocument(account.getClientDocument());
              reportAccount.setDate(dateFormat);

              return reportAccount;

            }).collect(Collectors.toList());

    reportAccountRepository.saveAll(listReportCardDocuments);

  }
}
