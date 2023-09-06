package com.microservice.reports.service.movements;

import com.microservice.reports.document.movements.MovementsDocuments;
import java.util.List;

/**
 * Esta interfaz tiene un método que devolverá todos los movimientos.
 * */
public interface MovementsService {

  List<MovementsDocuments> getMovements();
}
