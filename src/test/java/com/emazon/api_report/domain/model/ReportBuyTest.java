package com.emazon.api_report.domain.model;

import com.emazon.api_report.domain.util.ConstantsDomain;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReportBuyTest {

    @Test
    void shouldReportBuy() {
        LocalDateTime buyDate = LocalDateTime.now();
        ReportBuy reportBuy = new ReportBuy(ConstantsDomain.FIELD_NAME, ConstantsDomain.FIELD_NAME, buyDate,
                buyDate, ConstantsDomain.PRICE,new ArrayList<>());

        assertNotNull(reportBuy);
        assertEquals(ConstantsDomain.FIELD_NAME, reportBuy.getId());
        assertEquals(ConstantsDomain.FIELD_NAME, reportBuy.getUserName());
        assertEquals(buyDate, reportBuy.getCreateDate());
        assertEquals(buyDate, reportBuy.getBuyDate());
        assertEquals(ConstantsDomain.PRICE, reportBuy.getTotalPrice());
        assertEquals(new ArrayList<>(), reportBuy.getArticleDetails());
    }

    @Test
    void shouldReportBuySet() {
        LocalDateTime buyDate = LocalDateTime.now();
        ReportBuy reportBuy = new ReportBuy();
        reportBuy.setId(ConstantsDomain.FIELD_NAME);
        reportBuy.setUserName(ConstantsDomain.FIELD_NAME);
        reportBuy.setBuyDate(buyDate);
        reportBuy.setCreateDate(buyDate);
        reportBuy.setTotalPrice(ConstantsDomain.PRICE);
        reportBuy.setArticleDetails(new ArrayList<>());

        assertNotNull(reportBuy);
        assertEquals(ConstantsDomain.FIELD_NAME, reportBuy.getId());
        assertEquals(ConstantsDomain.FIELD_NAME, reportBuy.getUserName());
        assertEquals(buyDate, reportBuy.getCreateDate());
        assertEquals(buyDate, reportBuy.getBuyDate());
        assertEquals(ConstantsDomain.PRICE, reportBuy.getTotalPrice());
        assertEquals(new ArrayList<>(), reportBuy.getArticleDetails());
    }
}
