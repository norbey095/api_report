package com.emazon.api_report.infraestructure.output.entity;

import com.emazon.api_report.application.dto.ArticleDetailsDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "report")
public class ReportEntity {

    @Id
    private String id;
    @Indexed
    private String userName;
    private LocalDateTime createDate;
    @Indexed
    private LocalDateTime buyDate;
    private double totalPrice;
    private List<ArticleDetailsDto> articleDetails;
}
