package com.emazon.api_report.infraestructure.configuration;

import com.emazon.api_report.domain.api.IReportServicePort;
import com.emazon.api_report.domain.spi.IReportPersistencePort;
import com.emazon.api_report.domain.usecase.ReportUseCase;
import com.emazon.api_report.infraestructure.output.adapter.ReportAdapter;
import com.emazon.api_report.infraestructure.output.mapper.IReportEntityMapper;
import com.emazon.api_report.infraestructure.output.repository.IReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IReportRepository reportRepository;
    private final IReportEntityMapper reportEntityMapper;

    @Bean
    public IReportPersistencePort iReportPersistencePort(){
        return new ReportAdapter(reportRepository,reportEntityMapper);
    }

    @Bean
    public IReportServicePort brandServicePort(){
        return new ReportUseCase(iReportPersistencePort());
    }

}
