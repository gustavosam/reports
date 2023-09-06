package com.microservice.reports.service;

import com.microservice.reports.model.ReportAccount;

/**
 * Interfaz que contiene un método que devuelve el reporte de cuentas.
 * */
public interface ReportAccountService {

  ReportAccount getReportAccount(String accountNumber, String document, String date);
}
