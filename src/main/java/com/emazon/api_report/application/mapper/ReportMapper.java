package com.emazon.api_report.application.mapper;

import com.emazon.api_report.application.dto.ReportBuyDto;
import com.emazon.api_report.domain.model.ReportBuy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReportMapper {

    ReportBuy reportBuyDtoToReportBuy(ReportBuyDto reportBuyDto);
}
