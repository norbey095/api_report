package com.emazon.api_report.infraestructure.output.adapter;

import com.emazon.api_report.domain.model.ReportBuy;
import com.emazon.api_report.domain.spi.IReportPersistencePort;
import com.emazon.api_report.infraestructure.output.entity.ReportEntity;
import com.emazon.api_report.infraestructure.output.mapper.IReportEntityMapper;
import com.emazon.api_report.infraestructure.output.repository.IReportRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReportAdapter implements IReportPersistencePort {

    private final IReportRepository reportRepository;
    private final IReportEntityMapper reportEntityMapper;


    @Override
    public void saveReport(ReportBuy reportBuy) {
        ReportEntity reportEntity = reportEntityMapper.reportBuyToReportEntity(reportBuy);
        reportRepository.save(reportEntity);
    }

    @Override
    public List<ReportBuy> getBuy(String userName) {
        return  reportEntityMapper.entityListToReportList(reportRepository.findByUserName(userName));
    }
}
