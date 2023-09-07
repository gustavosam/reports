package com.microservice.reports.service.mapper;

import com.microservice.reports.document.ReportAccountDocument;
import com.microservice.reports.document.ReportCardDocument;
import com.microservice.reports.document.movements.MovementsDocuments;
import com.microservice.reports.model.DailyAmounts;
import com.microservice.reports.model.Movements;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {

  Movements mapMovementDocToMovements(MovementsDocuments movementsDocuments);

  DailyAmounts mapRecordAccountDoctoDailyAmounts(ReportAccountDocument
                                                         reportCardDocument);

  DailyAmounts mapRecordCardDoctoDailyAmounts(ReportCardDocument reportCardDocument);
}
