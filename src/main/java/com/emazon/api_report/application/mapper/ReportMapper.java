package com.emazon.api_report.application.mapper;

import com.emazon.api_report.application.dto.ReportBuyDto;
import com.emazon.api_report.domain.model.ReportBuy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReportMapper {

    ReportBuy reportBuyDtoToReportBuy(ReportBuyDto reportBuyDto);

    List<ReportBuyDto> reportListToReportDtoList(List<ReportBuy> reportBuy);
}
