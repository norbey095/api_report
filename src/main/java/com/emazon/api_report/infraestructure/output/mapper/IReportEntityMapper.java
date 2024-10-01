package com.emazon.api_report.infraestructure.output.mapper;

import com.emazon.api_report.domain.model.ReportBuy;
import com.emazon.api_report.infraestructure.output.entity.ReportEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IReportEntityMapper {

    ReportEntity reportBuyToReportEntity(ReportBuy reportBuy);
}
