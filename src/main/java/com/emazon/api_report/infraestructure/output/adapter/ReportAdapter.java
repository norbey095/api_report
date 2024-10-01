package com.emazon.api_report.infraestructure.output.adapter;

import com.emazon.api_report.domain.model.ReportBuy;
import com.emazon.api_report.domain.spi.IReportPersistencePort;
import com.emazon.api_report.infraestructure.output.entity.ReportEntity;
import com.emazon.api_report.infraestructure.output.mapper.ReportEntityMapper;
import com.emazon.api_report.infraestructure.output.repository.IReportRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReportAdapter implements IReportPersistencePort {

    private final IReportRepository reportRepository;
    private final ReportEntityMapper reportEntityMapper;


    @Override
    public void saveReport(ReportBuy reportBuy) {
        ReportEntity reportEntity = reportEntityMapper.reportBuyToReportEntity(reportBuy);
        reportRepository.save(reportEntity);
    }
}