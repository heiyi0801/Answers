package com.example.technical_test.repository;

import com.example.technical_test.model.FutureTransactionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FutureTransactionRecordRepository extends JpaRepository<FutureTransactionRecord, Long> {
    List<FutureTransactionRecord> findByClientNumber(String clientNumber);
}
