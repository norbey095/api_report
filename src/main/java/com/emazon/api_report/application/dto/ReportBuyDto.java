package com.emazon.api_report.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReportBuyDto {

    private String id;
    private String userName;
    private LocalDateTime createDate;
    private LocalDateTime buyDate;
    private double totalPrice;
    private List<ArticleDetailsDto> articleDetails;

}
