package com.microservice.reports.service;

import com.microservice.reports.model.Movements;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * La interfaz contendrá un método que devolverá todos los movimientos en un rango de fecha.
 * */
public interface ReportMovementsService {

  Flux<Movements> getAllMovements(String date);
}
