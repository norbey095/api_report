package com.emazon.api_report.infraestructure.output.mapper;

import com.emazon.api_report.domain.model.ArticleDetail;
import com.emazon.api_report.domain.model.ReportBuy;
import com.emazon.api_report.domain.util.ConstantsDomain;
import com.emazon.api_report.infraestructure.output.entity.ReportEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class IReportEntityMapperTest {

    private final IReportEntityMapper reportEntityMapper = Mappers.getMapper(IReportEntityMapper.class);


    @Test
    void testCartEntityToCartSave() {
        ArticleDetail articleDetail = new ArticleDetail(ConstantsDomain.NUMBER_1, ConstantsDomain.FIELD_NAME,
                ConstantsDomain.PRICE,ConstantsDomain.NUMBER_1);
        List<ArticleDetail> articleDetailList = new ArrayList<>();
        articleDetailList.add(articleDetail);

        LocalDateTime buyDate = LocalDateTime.now();

        ReportBuy reportBuy = new ReportBuy();
        reportBuy.setId(ConstantsDomain.FIELD_NAME);
        reportBuy.setUserName(ConstantsDomain.FIELD_NAME);
        reportBuy.setBuyDate(buyDate);
        reportBuy.setCreateDate(buyDate);
        reportBuy.setTotalPrice(ConstantsDomain.PRICE);
        reportBuy.setArticleDetails(articleDetailList);


        ReportEntity reportEntity = reportEntityMapper.reportBuyToReportEntity(reportBuy);


        assertNotNull(reportEntity);
        assertEquals(reportEntity.getId(), reportBuy.getId());
        assertEquals(reportEntity.getUserName(), reportBuy.getUserName());
        assertEquals(reportEntity.getBuyDate(), reportBuy.getBuyDate());
        assertEquals(reportEntity.getCreateDate(), reportBuy.getCreateDate());
        assertEquals(reportEntity.getTotalPrice(), reportBuy.getTotalPrice());
    }

    @Test
    void testCartEntityToCartSaveNull() {
        ReportEntity reportEntity = reportEntityMapper.reportBuyToReportEntity(null);

        assertNull(reportEntity);
    }
}