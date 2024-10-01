package com.emazon.api_report.domain.spi;

import com.emazon.api_report.domain.model.ReportBuy;

public interface IReportPersistencePort {

        void saveReport(ReportBuy reportBuy);
}
