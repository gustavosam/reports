package com.microservice.reports.service.movements;

import com.microservice.reports.document.movements.MovementsDocuments;
import com.microservice.reports.repository.movements.MovementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * Esta clase implementará la interfaz MovementService
 * y tiene un método que devolverá la lista de los movimientos.
 * */

@Service
public class MovementsServiceImpl implements MovementsService {

  @Autowired
  private MovementsRepository movementsRepository;

  @Override
  public Flux<MovementsDocuments> getMovements() {
    return movementsRepository.findByCommissionGreaterThan(0.0);
  }
}
