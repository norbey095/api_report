package com.emazon.api_report.infraestructure.output.repository;

import com.emazon.api_report.infraestructure.output.entity.ReportEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IReportRepository extends MongoRepository<ReportEntity, Integer> {

    List<ReportEntity> findByUserName(String userName);
}
