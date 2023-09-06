package com.microservice.reports.repository.movements;

import com.microservice.reports.document.movements.MovementsDocuments;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Esta interfaz contiene los métodos necesarios para el crud con movementsDocuments.
 * */
@Repository
public interface MovementsRepository extends MongoRepository<MovementsDocuments, String> {

  List<MovementsDocuments> findByCommissionGreaterThan(Double amount);

}
