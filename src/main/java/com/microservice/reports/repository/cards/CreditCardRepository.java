package com.microservice.reports.repository.cards;

import com.microservice.reports.document.cards.CreditCardDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Esta interfaz contiene los métodos necesarios para el crud a la colección
 * CreditCard.
 * */
public interface CreditCardRepository extends ReactiveMongoRepository<CreditCardDocument, String> {

}
