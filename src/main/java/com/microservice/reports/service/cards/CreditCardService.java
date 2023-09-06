package com.microservice.reports.service.cards;

import com.microservice.reports.document.cards.CreditCardDocument;
import java.util.List;

/**
 * La interfaz que contendrá un método para obtener todas las tarjetas.
 * */
public interface CreditCardService {

  List<CreditCardDocument> getAllCards();
}
