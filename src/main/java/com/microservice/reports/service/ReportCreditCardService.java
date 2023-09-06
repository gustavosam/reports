package com.microservice.reports.service;

import com.microservice.reports.model.ReportCard;

/**
 * Interfaz que contiene un método que obtiene todos los reportes de tarjetas
 * por número de tarjeta, document de cliente y una fecha.
 * */
public interface ReportCreditCardService {

  ReportCard getReportCard(String cardNumber, String document, String date);
}
