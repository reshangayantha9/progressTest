package com.example.ProgressTest.controller;

import com.example.ProgressTest.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/main/report")
public class ReportController {
    @Autowired
    ReportService reportService;
    @GetMapping("/{date}")
    public String getIncome(@PathVariable LocalDate date){
        return reportService.exportReport(date);
    }
}
