package com.emazon.api_report.domain.api;

import com.emazon.api_report.domain.model.ReportBuy;

import java.util.List;

public interface IReportServicePort {

        void saveReport(ReportBuy reportBuy);

        List<ReportBuy> getBuy(String userName);
}
