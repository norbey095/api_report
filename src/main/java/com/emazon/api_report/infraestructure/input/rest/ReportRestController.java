package com.emazon.api_report.infraestructure.input.rest;

import com.emazon.api_report.application.dto.ReportBuyDto;
import com.emazon.api_report.application.dto.ResponseSuccess;
import com.emazon.api_report.application.handler.IReportHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class ReportRestController {

    private final IReportHandler reportHandler;

    @Operation(summary = "Add a new report",
            description = "Save a report")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Report created", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<ResponseSuccess> createReport(@RequestBody ReportBuyDto reportBuyDto){
        ResponseSuccess responseSuccess = reportHandler.saveReport(reportBuyDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(responseSuccess);
    }

    @Operation(summary = "get buy by userName",
            description = "get buy by userName")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "get buy by userName", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<ReportBuyDto>> getBuy(@RequestParam String userName){
        List<ReportBuyDto> responseSuccess = reportHandler.getBuy(userName);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(responseSuccess);
    }
}