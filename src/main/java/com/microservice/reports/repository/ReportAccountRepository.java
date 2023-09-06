package com.microservice.reports.repository;

import com.microservice.reports.document.ReportAccountDocument;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * Interfaz que tendrá los métodos para un crud de ReportAccountDocument.
 * */
public interface ReportAccountRepository extends MongoRepository<ReportAccountDocument, String> {

  List<ReportAccountDocument> findByAccountNumberAndClientDocumentAndDateStartingWith(
          String accountNumber, String clientDocument, String date);

}
