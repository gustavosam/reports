package com.microservice.reports.service.mapper;

import com.microservice.reports.document.ReportAccountDocument;
import com.microservice.reports.document.ReportCardDocument;
import com.microservice.reports.document.movements.MovementsDocuments;
import com.microservice.reports.model.DailyAmounts;
import com.microservice.reports.model.Movements;
import org.mapstruct.Mapping;

/**
 * Interfaz mapstruct para mapeo de clases.
 * */
@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {

  Movements mapMovementDocToMovements(MovementsDocuments movementsDocuments);


  @Mapping(target = "date", source = "reportAccountDocument.date")
  @Mapping(target = "amount", source = "reportAccountDocument.accountAmount")
  DailyAmounts mapRecordAccountDoctoDailyAmounts(ReportAccountDocument
                                                         reportAccountDocument);

  @Mapping(target = "date", source = "reportCardDocument.date")
  @Mapping(target = "amount", source = "reportCardDocument.cardAmount")
  DailyAmounts mapRecordCardDoctoDailyAmounts(ReportCardDocument reportCardDocument);
}
