package com.emazon.api_report.infraestructure.output.mapper;

import com.emazon.api_report.domain.model.ReportBuy;
import com.emazon.api_report.infraestructure.output.entity.ReportEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IReportEntityMapper {

    ReportEntity reportBuyToReportEntity(ReportBuy reportBuy);

    List<ReportBuy> entityListToReportList(List<ReportEntity> entityList);
}
