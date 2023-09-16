package com.microservice.reports.repository.accounts;

import com.microservice.reports.document.accounts.AccountsDocuments;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


/**
 * Esta interfaz es la encargada de contener los métodos para
 * el crud de cuentas.
 * */
public interface AccountRepository extends ReactiveMongoRepository<AccountsDocuments, String> {
}
