package com.emazon.api_report.domain.api;

import com.emazon.api_report.domain.model.ReportBuy;

public interface IReportServicePort {

        void saveReport(ReportBuy reportBuy);
}
