package com.microservice.reports.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase que representará a la colección reportcard
 * Contendrá la información de los saldos de las tarjetas.
 * */
@Getter
@Setter
@Document(collection = "reportcard")
public class ReportCardDocument {

  @Id
  private String id;

  private String date;

  private String cardNumber;

  private Double cardAmount;

  private String clientDocument;
}
