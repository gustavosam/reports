package com.microservice.reports.service.cards;

import com.microservice.reports.document.cards.CreditCardDocument;
import com.microservice.reports.repository.cards.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * Esta clase implementa la interfaz CreditCardService
 * Y obtendrá y retornará todas las tarjetas de créditos.
 * */

@Service
public class CreditCardServiceImpl implements CreditCardService {

  @Autowired
  private CreditCardRepository creditCardRepository;

  @Override
  public Flux<CreditCardDocument> getAllCards() {
    return creditCardRepository.findAll();
  }
}
