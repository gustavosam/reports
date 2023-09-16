package com.microservice.reports.service;

import com.microservice.reports.model.ReportCard;
import reactor.core.publisher.Mono;

/**
 * Interfaz que contiene un método que obtiene todos los reportes de tarjetas
 * por número de tarjeta, document de cliente y una fecha.
 * */
public interface ReportCreditCardService {

  Mono<ReportCard> getReportCard(String cardNumber, String document, String date);
}
