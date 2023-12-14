package com.example.technical_test.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.technical_test.model.FutureTransactionRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class FutureTransactionRecordRepositoryTest {

    @Autowired
    private FutureTransactionRecordRepository futureTransactionRecordRepository;

    private FutureTransactionRecord futureTransactionRecord;

    @BeforeEach
    public void setup(){
        futureTransactionRecord = FutureTransactionRecord.builder()
                .clientType("CL  ")
                .clientNumber("1234")
                .accountNumber("0002")
                .subAccountNumber("0001")
                .exchangeCode("SGX ")
                .productGroupCode("FU")
                .symbol("NK    ")
                .expirationDate("20100910")
                .totalTransactionAmount("1")
                .build();
    }

    // JUnit test for save futureTransactionRecord operation
    //@DisplayName("JUnit test for save futureTransactionRecord operation")
    @Test
    public void givenFutureTransactionRecord_whenSave_thenReturnSavedFutureTransactionRecord(){

        // when - action or the behaviour that we are going test
        FutureTransactionRecord savedFutureTransactionRecord = futureTransactionRecordRepository.save(futureTransactionRecord);

        // then - verify the output
        assertThat(savedFutureTransactionRecord).isNotNull();
        assertEquals(savedFutureTransactionRecord.getClientNumber(), "1234");
    }

    // JUnit test for get all futureTransactionRecord operation
    @Test
    @DisplayName("JUnit test for get all futureTransactionRecord operation")
    public void givenFutureTransactionRecordList_whenFindAll_thenFutureTransactionRecordList(){
        // given - precondition or setup

        FutureTransactionRecord futureTransactionRecord_2 = FutureTransactionRecord.builder()
                .clientType("CL  ")
                .clientNumber("4321")
                .accountNumber("0003")
                .subAccountNumber("0001")
                .exchangeCode("CME ")
                .productGroupCode("FU")
                .symbol("N1    ")
                .expirationDate("20100910")
                .totalTransactionAmount("-6")
                .build();

        futureTransactionRecordRepository.save(futureTransactionRecord);
        futureTransactionRecordRepository.save(futureTransactionRecord_2);

        // when -  action or the behaviour that we are going test
        List<FutureTransactionRecord> futureTransactionRecordList = futureTransactionRecordRepository.findAll();

        // then - verify the output
        assertThat(Collections.singletonList(futureTransactionRecordList)).isNotNull();
        assertThat(futureTransactionRecordList.size()).isEqualTo(2);
    }

    // JUnit test for get futureTransactionRecord by clientNumber operation
    @Test
    @DisplayName("JUnit test for get futureTransactionRecord by id operation")
    public void givenFutureTransactionRecordObject_whenFindById_thenReturnFutureTransactionRecordObject(){

        futureTransactionRecordRepository.save(futureTransactionRecord);

        // when -  action or the behaviour that we are going test
        FutureTransactionRecord futureTransactionRecordDB = futureTransactionRecordRepository.findById(futureTransactionRecord.getId()).get();

        // then - verify the output
        assertThat(futureTransactionRecordDB).isNotNull();
    }


}