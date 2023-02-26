package com.example.RIB.service;

import com.example.RIB.entity.Rib;
import com.example.RIB.repository.RibRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RibService {

    @Autowired
    RibRepository ribRepository;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\hp\\Desktop\\Report";
        List<Rib> ribs = ribRepository.findAll();
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:rib.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ribs);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "ZAHRA");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\rib.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\rib.pdf");
        }

        return "report generated in path : " + path;
    }
}
