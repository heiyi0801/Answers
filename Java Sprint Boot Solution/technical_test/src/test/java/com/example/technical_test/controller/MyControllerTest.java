package com.example.technical_test.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllRecords() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/report");

        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    public void getByClientNumber() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/report/1234");

        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().is(200));
    }
}