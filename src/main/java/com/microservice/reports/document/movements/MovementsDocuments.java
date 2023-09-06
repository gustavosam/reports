package com.microservice.reports.document.movements;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Esta clase representa a la colección movements en mongo db.
 * */
@Document(collection = "movements")
@Getter
@Setter
public class MovementsDocuments {

  @Id
  private String movementNumber;

  private String movementType;

  private String clientDocument;

  private String accountType;

  private String accountNumber;

  private Double amount;

  private Double commission;

  private LocalDate movementDate;
}
