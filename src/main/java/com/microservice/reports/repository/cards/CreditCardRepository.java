package com.microservice.reports.repository.cards;

import com.microservice.reports.document.cards.CreditCardDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Esta interfaz contiene los métodos necesarios para el crud a la colección
 * CreditCard.
 * */
public interface CreditCardRepository extends MongoRepository<CreditCardDocument, String> {

}
