package com.microservice.reports.repository;

import com.microservice.reports.document.ReportCardDocument;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * Interfaz que tendrá métodos para realizar un crud a la colección ReportCardDocument.
 * */
@Repository
public interface ReportCardRepository extends ReactiveMongoRepository<ReportCardDocument, String> {

  Flux<ReportCardDocument> findByCardNumberAndClientDocumentAndDateStartingWith(
          String cardNumber, String clientDocument, String date);
}
