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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
  @Scheduled(fixedRate = 600000)
  public Mono<Void> executeAccounts() {

    LocalDate localDate = LocalDate.now();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    String dateFormat = localDate.format(formatter);

    Flux<AccountsDocuments> accountsFlux = accountService.getAllAccounts();

    Flux<ReportAccountDocument> reportAccountFlux = accountsFlux
            .filter(Objects::nonNull)
            .map(accountDoc -> {
              ReportAccountDocument reportAccount = new ReportAccountDocument();
              reportAccount.setAccountNumber(accountDoc.getAccountNumber());
              reportAccount.setAccountAmount(accountDoc.getAccountAmount());
              reportAccount.setClientDocument(accountDoc.getClientDocument());
              reportAccount.setDate(dateFormat);
              return reportAccount;
            });

    Flux<ReportAccountDocument> savedAccountsFlux = reportAccountRepository.saveAll(reportAccountFlux);

    savedAccountsFlux.then().subscribe();

    return Mono.empty();
  }
}
