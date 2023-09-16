package com.microservice.reports.service.account;

import com.microservice.reports.document.accounts.AccountsDocuments;
import com.microservice.reports.repository.accounts.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * Esta clase implementa la interfaz con el método para obtener
 * todas las cuentas.
 *
 * */
@Service
public class AccountServiceImpl implements AccountService {

  @Autowired
  private AccountRepository accountRepository;

  @Override
  public Flux<AccountsDocuments> getAllAccounts() {
    return accountRepository.findAll();
  }
}
