package com.microservice.reports.service.cards;

import com.microservice.reports.document.cards.CreditCardDocument;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * La interfaz que contendrá un método para obtener todas las tarjetas.
 * */
public interface CreditCardService {

  Flux<CreditCardDocument> getAllCards();
}
