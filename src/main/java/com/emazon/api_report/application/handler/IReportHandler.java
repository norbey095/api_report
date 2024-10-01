package com.emazon.api_report.application.handler;

import com.emazon.api_report.application.dto.ReportBuyDto;
import com.emazon.api_report.application.dto.ResponseSuccess;

public interface IReportHandler {

    ResponseSuccess saveReport(ReportBuyDto reportBuyDto);

   }
