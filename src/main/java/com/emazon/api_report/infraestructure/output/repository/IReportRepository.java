package com.emazon.api_report.infraestructure.output.repository;

import com.emazon.api_report.infraestructure.output.entity.ReportEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IReportRepository extends MongoRepository<ReportEntity, Integer> {

}
