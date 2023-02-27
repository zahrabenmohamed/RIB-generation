package com.example.RIB.controller;

import com.example.RIB.entity.Rib;
import com.example.RIB.repository.RibRepository;
import com.example.RIB.service.RibService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
public class RibController {

    @Autowired
    RibRepository ribRepository;

    @Autowired
    RibService ribService;


    @GetMapping("/rib/{id}")
    public List<Rib> getBin(@PathVariable Integer id) {
        return ribRepository.findRibById(id);
    }

    @GetMapping("/rib/{id}/{format}")
    public String generateRIB(@PathVariable Integer id,@PathVariable String format) throws JRException, FileNotFoundException {
        return ribService.exportReport(id, format);

    }
}
