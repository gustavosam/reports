package com.microservice.reports.service;

import com.microservice.reports.model.Movements;
import java.util.List;

/**
 * La interfaz contendrá un método que devolverá todos los movimientos en un rango de fecha.
 * */
public interface ReportMovementsService {

  List<Movements> getAllMovements(String date);
}
