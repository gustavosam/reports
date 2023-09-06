package com.microservice.reports.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase que representa a la colección reportaccount en mongo db
 * Guardará los saldos diarios de las cuentas.
 * */
@Getter
@Setter
@Document(collection = "reportaccount")
public class ReportAccountDocument {

  @Id
  private String id;

  private String date;

  private String accountNumber;

  private Double accountAmount;

  private String clientDocument;
}
