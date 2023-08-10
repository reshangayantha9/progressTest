package com.example.ProgressTest.service.serviceImpl;

import com.example.ProgressTest.entity.Order;
import com.example.ProgressTest.repository.OrderRepository;
import com.example.ProgressTest.service.ReportService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public String exportReport(LocalDate date)  {
        try {
            String path = "D:\\";
            List<Order> orders = orderRepository.findDaily(date);
            Double income=Double.parseDouble(orderRepository.dailyIncome(date));
            File file = ResourceUtils.getFile("classpath:IncomeReport.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(orders);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("income",income.toString());
            parameters.put("date",date);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, dataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\dailyIncome.pdf");

            return "report generated in path : " + path;
        }catch (Exception e){
            return "report generated fail \n"+ e.getMessage();
        }



    }
}
