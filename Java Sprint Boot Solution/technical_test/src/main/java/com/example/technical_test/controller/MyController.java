package com.example.technical_test.controller;

import com.example.technical_test.model.FutureTransactionRecord;
import com.example.technical_test.service.FutureTransactionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MyController {
    @Autowired
    private FutureTransactionRecordService futureTransactionRecordService;

    @GetMapping("/report")
    public List<FutureTransactionRecord> report() {
        return futureTransactionRecordService.findAllRecords();
    }

    @GetMapping("/report/{clientNumber}")
    public List<FutureTransactionRecord> report(@PathVariable("clientNumber") String clientNumber) {
        return futureTransactionRecordService.findByClientNumber(clientNumber);
    }


}
