package com.microservice.reports.service;

import com.microservice.reports.model.ReportAccount;
import reactor.core.publisher.Mono;

/**
 * Interfaz que contiene un método que devuelve el reporte de cuentas.
 * */
public interface ReportAccountService {

  Mono<ReportAccount> getReportAccount(String accountNumber, String document, String date);
}
