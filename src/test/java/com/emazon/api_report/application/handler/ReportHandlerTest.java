package com.emazon.api_report.application.handler;

import com.emazon.api_report.application.dto.ReportBuyDto;
import com.emazon.api_report.application.mapper.ReportMapper;
import com.emazon.api_report.application.util.ConstantsApplication;
import com.emazon.api_report.domain.api.IReportServicePort;
import com.emazon.api_report.domain.model.ReportBuy;
import com.emazon.api_report.domain.util.ConstantsDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

class ReportHandlerTest {

    @InjectMocks
    private ReportHandler reportHandler;

    @Mock
    private ReportMapper reportMapper;

    @Mock
    private IReportServicePort reportServicePort;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldSaveReport() {

        LocalDateTime buyDate = LocalDateTime.now();
        ReportBuy reportBuy = new ReportBuy(ConstantsDomain.FIELD_NAME, ConstantsDomain.FIELD_NAME, buyDate,
                buyDate, ConstantsDomain.PRICE,new ArrayList<>());

        ReportBuyDto reportBuyDto = new ReportBuyDto(ConstantsApplication.NAME
                ,ConstantsApplication.NAME,buyDate, buyDate, ConstantsApplication.PRICE ,new ArrayList<>());

        when(reportMapper.reportBuyDtoToReportBuy(reportBuyDto)).thenReturn(reportBuy);

        reportHandler.saveReport(reportBuyDto);

        Mockito.verify(reportMapper, Mockito.times(ConstantsApplication.NUMBER_1)).
                reportBuyDtoToReportBuy(reportBuyDto);
    }
}
