package com.emazon.api_report.domain.usecase;

import com.emazon.api_report.domain.api.IReportServicePort;
import com.emazon.api_report.domain.model.ReportBuy;
import com.emazon.api_report.domain.spi.IReportPersistencePort;

import java.util.List;

public class ReportUseCase implements IReportServicePort {

    private final IReportPersistencePort reportPersistencePort;

    public ReportUseCase(IReportPersistencePort reportPersistencePort) {
        this.reportPersistencePort = reportPersistencePort;
    }

    @Override
    public void saveReport(ReportBuy reportBuy) {
        reportPersistencePort.saveReport(reportBuy);
    }

    @Override
    public List<ReportBuy> getBuy(String userName) {
        return reportPersistencePort.getBuy(userName);
    }
}
