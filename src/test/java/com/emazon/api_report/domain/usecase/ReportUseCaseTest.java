package com.emazon.api_report.domain.usecase;

import com.emazon.api_report.domain.model.ReportBuy;
import com.emazon.api_report.domain.spi.IReportPersistencePort;
import com.emazon.api_report.domain.util.ConstantsDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;

class ReportUseCaseTest {

    @Mock
    private IReportPersistencePort reportPersistencePort;

    @InjectMocks
    private ReportUseCase reportUseCase;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCartSave() {
        LocalDateTime buyDate = LocalDateTime.now();
        ReportBuy reportBuy = new ReportBuy(ConstantsDomain.FIELD_NAME, ConstantsDomain.FIELD_NAME, buyDate,
                buyDate, ConstantsDomain.PRICE,new ArrayList<>());
        Mockito.doNothing().when(reportPersistencePort).saveReport(reportBuy);

        reportUseCase.saveReport(reportBuy);

        Mockito.verify(reportPersistencePort, Mockito.times(ConstantsDomain.NUMBER_1))
                .saveReport(reportBuy);
    }
}