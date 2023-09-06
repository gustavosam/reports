package com.microservice.reports.service.account;

import com.microservice.reports.document.accounts.AccountsDocuments;
import java.util.List;

/**
 * Esta interfaz tendrá un método para obtener todas las cuentas.
 * */
public interface AccountService {

  List<AccountsDocuments> getAllAccounts();
}
