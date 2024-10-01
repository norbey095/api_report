package com.emazon.api_report.application.mapper;

import com.emazon.api_report.application.dto.ArticleDetailsDto;
import com.emazon.api_report.application.dto.ReportBuyDto;
import com.emazon.api_report.application.util.ConstantsApplication;
import com.emazon.api_report.domain.model.ReportBuy;
import com.emazon.api_report.domain.util.ConstantsDomain;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReportMapperTest {

    private final ReportMapper reportMapper = Mappers.getMapper(ReportMapper.class);

    @Test
    void testReportBuyDtoToReportBuy() {
        ArticleDetailsDto articleDetailsDto = new ArticleDetailsDto(ConstantsDomain.NUMBER_1, ConstantsDomain.FIELD_NAME,
                ConstantsDomain.PRICE,ConstantsDomain.NUMBER_1);
        List<ArticleDetailsDto> articleDetailsDtoList = new ArrayList<>();
        articleDetailsDtoList.add(articleDetailsDto);

        LocalDateTime buyDate = LocalDateTime.now();

        ReportBuyDto reportBuyDto = new ReportBuyDto(ConstantsApplication.NAME
                ,ConstantsApplication.NAME,buyDate, buyDate, ConstantsApplication.PRICE ,articleDetailsDtoList);

        ReportBuy reportBuy = reportMapper.reportBuyDtoToReportBuy(reportBuyDto);

        assertNotNull(reportBuy);
        assertEquals(reportBuyDto.getId(),reportBuy.getId());
        assertEquals(reportBuyDto.getUserName(),reportBuy.getUserName());
        assertEquals(reportBuyDto.getTotalPrice(),reportBuy.getTotalPrice());
    }
}