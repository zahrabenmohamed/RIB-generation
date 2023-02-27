package com.example.RIB.service;

import com.example.RIB.entity.Rib;
import com.example.RIB.repository.RibRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

@Service
public class RibService {

    @Autowired
    RibRepository ribRepository;

    public String exportReport(Integer id, String reportFormat) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\hp\\Desktop\\Report";
        List<Rib> ribs = ribRepository.findRibById(id);
        Rib rib = ribs.get(0);
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:rib.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanArrayDataSource dataSource = new JRBeanArrayDataSource(new Rib[]{rib});
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "ZAHRA");
        System.out.println(ribs);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\rib.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\rib"+id+".pdf");
        }

        return "report generated in path : " + path;
    }
}
