package com.microservice.reports.service;

import com.microservice.reports.model.Movements;
import com.microservice.reports.service.mapper.Mappers;
import com.microservice.reports.service.movements.MovementsService;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase implementa a los métodos de la interfaz ReportMovementsService.
 * */
@Service
public class ReportMovementsServiceImpl implements ReportMovementsService {

  @Autowired
  private MovementsService movementsService;

  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


  /**
   * El método getAllMovements, mostrará todos los movimientos que contienen comisión y que
   * sean de una fecha en específico.
   * */
  @Override
  public List<Movements> getAllMovements(String date) {

    return movementsService.getMovements()
            .stream()
            .filter(Objects::nonNull)
            .filter(movement -> (movement.getMovementDate()).format(formatter).startsWith(date))
            .map(Mappers::mapMovementDocToMovements)
            .collect(Collectors.toList());
  }
}
