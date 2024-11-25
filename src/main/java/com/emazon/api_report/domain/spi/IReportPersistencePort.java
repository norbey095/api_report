package com.emazon.api_report.domain.spi;

import com.emazon.api_report.domain.model.ReportBuy;

import java.util.List;

public interface IReportPersistencePort {

        void saveReport(ReportBuy reportBuy);

        List<ReportBuy> getBuy(String userName);
}
