package com.microservice.reports.repository;

import com.microservice.reports.document.ReportCardDocument;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que tendrá métodos para realizar un crud a la colección ReportCardDocument.
 * */
@Repository
public interface ReportCardRepository extends MongoRepository<ReportCardDocument, String> {

  List<ReportCardDocument> findByCardNumberAndClientDocumentAndDateStartingWith(
          String cardNumber, String clientDocument, String date);
}
