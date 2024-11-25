package com.emazon.api_report.application.handler;

import com.emazon.api_report.application.dto.ReportBuyDto;
import com.emazon.api_report.application.dto.ResponseSuccess;
import com.emazon.api_report.application.mapper.ReportMapper;
import com.emazon.api_report.application.util.ConstantsHandler;
import com.emazon.api_report.domain.api.IReportServicePort;
import com.emazon.api_report.domain.model.ReportBuy;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReportHandler implements IReportHandler {

    private final IReportServicePort reportServicePort;
    private final ReportMapper reportMapper;


    @Override
    public ResponseSuccess saveReport(ReportBuyDto reportBuyDto) {
        ReportBuy reportBuy = reportMapper.reportBuyDtoToReportBuy(reportBuyDto);
        reportServicePort.saveReport(reportBuy);
        return new ResponseSuccess(ConstantsHandler.MESSAGES_SUCCESS, HttpStatus.CREATED.toString());
    }

    @Override
    public List<ReportBuyDto> getBuy(String userName) {
        return reportMapper.reportListToReportDtoList(reportServicePort.getBuy(userName));
    }
}