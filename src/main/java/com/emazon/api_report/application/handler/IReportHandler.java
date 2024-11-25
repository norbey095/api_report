package com.emazon.api_report.application.handler;

import com.emazon.api_report.application.dto.ReportBuyDto;
import com.emazon.api_report.application.dto.ResponseSuccess;

import java.util.List;

public interface IReportHandler {

    ResponseSuccess saveReport(ReportBuyDto reportBuyDto);

    List<ReportBuyDto> getBuy(String userName);

}
