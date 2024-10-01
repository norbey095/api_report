package com.emazon.api_report.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ArticleDetailsDto {

    private Integer articleId;
    private String name;
    private double unitPrice;
    private Integer quantity;
}
