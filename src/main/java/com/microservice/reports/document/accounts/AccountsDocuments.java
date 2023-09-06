package com.microservice.reports.document.accounts;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Esta clase representa a la colleción accounts en mongo db.
 * */
@Document(collection = "accounts")
@Getter
@Setter
public class AccountsDocuments {

  @Id
  private String accountNumber;

  private String accountType;

  private Double accountAmount;

  private Integer freeMovements;

  private String clientDocument;

  private LocalDate accountCreationDate;
}
