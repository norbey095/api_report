package com.emazon.api_report.infraestructure.output.adapter;

import com.emazon.api_report.domain.model.ReportBuy;
import com.emazon.api_report.infraestructure.output.entity.ReportEntity;
import com.emazon.api_report.infraestructure.output.mapper.IReportEntityMapper;
import com.emazon.api_report.infraestructure.output.repository.IReportRepository;
import com.emazon.api_report.infraestructure.util.ConstantsInfTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
class ReportAdapterTest {

    @Mock
    private IReportEntityMapper reportEntityMapper;

    @Mock
    private IReportRepository reportRepository;


    @InjectMocks
    private ReportAdapter reportAdapter;

    @Test
    void testSaveReport() {
        LocalDateTime buyDate = LocalDateTime.now();
        ReportBuy reportBuy= new ReportBuy(ConstantsInfTest.NAME, ConstantsInfTest.NAME, buyDate,
                buyDate,ConstantsInfTest.PRICE,new ArrayList<>());
        ReportEntity reportEntity = new ReportEntity();

        Mockito.when(reportEntityMapper.reportBuyToReportEntity(reportBuy))
                .thenReturn(reportEntity);

        reportAdapter.saveReport(reportBuy);

        Mockito.verify(reportEntityMapper, Mockito.times(ConstantsInfTest.NUMBER_1))
                .reportBuyToReportEntity(reportBuy);
    }


}