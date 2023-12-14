package com.example.technical_test.service;

import com.example.technical_test.model.FutureTransactionRecord;
import com.example.technical_test.repository.FutureTransactionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FutureTransactionRecordService {
    @Autowired
    private FutureTransactionRecordRepository futureTransactionRecordRepository;

    public List<FutureTransactionRecord> findAllRecords() {
        return futureTransactionRecordRepository.findAll();
    }

    public List<FutureTransactionRecord> findByClientNumber(String clientNumber) {
        return futureTransactionRecordRepository.findByClientNumber(clientNumber);
    }

}
