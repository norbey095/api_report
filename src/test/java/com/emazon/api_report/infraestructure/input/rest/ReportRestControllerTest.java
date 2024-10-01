package com.emazon.api_report.infraestructure.input.rest;

import com.emazon.api_report.application.dto.ReportBuyDto;
import com.emazon.api_report.application.dto.ResponseSuccess;
import com.emazon.api_report.application.handler.IReportHandler;
import com.emazon.api_report.application.util.ConstantsApplication;
import com.emazon.api_report.infraestructure.util.ConstantsInfTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class ReportRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private IReportHandler reportHandler;


    @Test
    void createReport_ShouldReturnStatusCreated() throws Exception {
        LocalDateTime buyDate = LocalDateTime.now();

        ReportBuyDto reportBuyDto = new ReportBuyDto(ConstantsApplication.NAME
                ,ConstantsApplication.NAME,buyDate, buyDate, ConstantsApplication.PRICE ,new ArrayList<>());
        ResponseSuccess responseSuccess = new ResponseSuccess(ConstantsInfTest.MESSAGESS_SUCCESS
                , HttpStatus.OK.toString());
        Mockito.when(reportHandler.saveReport(Mockito.any()))
                .thenReturn(responseSuccess);

        mockMvc.perform(MockMvcRequestBuilders.post(ConstantsInfTest.URL_CART)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reportBuyDto)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}