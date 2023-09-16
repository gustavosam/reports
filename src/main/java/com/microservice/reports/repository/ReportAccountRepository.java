package com.microservice.reports.repository;

import com.microservice.reports.document.ReportAccountDocument;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;


/**
 * Interfaz que tendrá los métodos para un crud de ReportAccountDocument.
 * */
public interface ReportAccountRepository extends ReactiveMongoRepository<ReportAccountDocument, String> {

  Flux<ReportAccountDocument> findByAccountNumberAndClientDocumentAndDateStartingWith(
          String accountNumber, String clientDocument, String date);

}
