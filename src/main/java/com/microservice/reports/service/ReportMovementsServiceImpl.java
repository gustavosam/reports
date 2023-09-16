package com.microservice.reports.service;

import com.microservice.reports.model.Movements;
import com.microservice.reports.service.mapper.Mapper;
import com.microservice.reports.service.movements.MovementsService;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * Esta clase implementa a los métodos de la interfaz ReportMovementsService.
 * */
@Service
public class ReportMovementsServiceImpl implements ReportMovementsService {

  @Autowired
  private MovementsService movementsService;

  @Autowired
  private Mapper mapper;

  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


  /**
   * El método getAllMovements, mostrará todos los movimientos que contienen comisión y que
   * sean de una fecha en específico.
   */
  @Override
  public Flux<Movements> getAllMovements(String date) {

    return movementsService.getMovements()
            .filter(Objects::nonNull)
            .filter(movement -> (movement.getMovementDate()).format(formatter).startsWith(date))
            .map(movementsDocuments -> mapper.mapMovementDocToMovements(movementsDocuments));
  }
}
