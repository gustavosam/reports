package com.microservice.reports.repository.movements;

import com.microservice.reports.document.movements.MovementsDocuments;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


/**
 * Esta interfaz contiene los métodos necesarios para el crud con movementsDocuments.
 * */
@Repository
public interface MovementsRepository extends ReactiveMongoRepository<MovementsDocuments, String> {

  Flux<MovementsDocuments> findByCommissionGreaterThan(Double amount);

}
