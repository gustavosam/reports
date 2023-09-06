package com.microservice.reports.service.cards;

import com.microservice.reports.document.cards.CreditCardDocument;
import com.microservice.reports.repository.cards.CreditCardRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase implementa la interfaz CreditCardService
 * Y obtendrá y retornará todas las tarjetas de créditos.
 * */

@Service
public class CreditCardServiceImpl implements CreditCardService {

  @Autowired
  private CreditCardRepository creditCardRepository;

  @Override
  public List<CreditCardDocument> getAllCards() {
    return creditCardRepository.findAll();
  }
}
