package com.example.technical_test;

import com.example.technical_test.model.FutureTransactionRecord;
import com.example.technical_test.repository.FutureTransactionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class InputFilePersistor {

    @Autowired
    private FutureTransactionRecordRepository futureTransactionRecordRepository;

    @PostConstruct
    public void execute() {
        int totalTransactionAmount;
        String headerStr = "CLIENT TYPE,CLIENT NUMBER,ACCOUNT NUMBER,SUBACCOUNT NUMBER,EXCHANGE CODE,PRODUCT GROUP CODE,\tSYMBOL,EXPIRATION DATE,TOTAL_TRANSACTION_AMOUNT";

        BufferedWriter writer;
        int count = 0;
        String joinedString;
        String[] rowData = new String[9];

        LocalDateTime myObj = LocalDateTime.now();
        String suffix = myObj.toString();
        suffix = suffix.substring(0, 4) + suffix.substring(5, 7)+ suffix.substring(8, 10)+ suffix.substring(11, 13)+ suffix.substring(14, 16)+ suffix.substring(17, 19);

        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader("Input.txt"))) {

            writer = new BufferedWriter(new FileWriter("Output_" + suffix + ".csv"));
            writer.write(headerStr);


            while ((line = reader.readLine()) != null) {

                count++;

                //Generate the JSON
                FutureTransactionRecord ftr = new FutureTransactionRecord();
                ftr.setClientType(line.substring(3, 7));
                ftr.setClientNumber(line.substring(7, 11));
                ftr.setAccountNumber(line.substring(11, 15));
                ftr.setSubAccountNumber((line.substring(15, 19)));
                ftr.setExchangeCode(line.substring(27, 31));
                ftr.setProductGroupCode(line.substring(25, 27));
                ftr.setSymbol(line.substring(31, 37));
                ftr.setExpirationDate(line.substring(37, 45));
                totalTransactionAmount = Integer.parseInt(line.substring(52, 62)) - Integer.parseInt(line.substring(63, 73));
                ftr.setTotalTransactionAmount(String.valueOf(totalTransactionAmount));

                futureTransactionRecordRepository.save(ftr);

                //Generate the csv file
                Arrays.fill(rowData, null);     //Clear all the values inside the array
                rowData[0] = line.substring(3,7);
                rowData[1] = line.substring(7,11);
                rowData[2] = line.substring(11,15);
                rowData[3] = line.substring(15,19);
                rowData[4] = line.substring(27,31);
                rowData[5] = line.substring(25,27);
                rowData[6] = line.substring(31,37);
                rowData[7] = line.substring(37,45);
                rowData[8] = String.valueOf(totalTransactionAmount);

                joinedString = String.join(",", rowData);
                writer.newLine();
                writer.write(joinedString);
            }
            reader.close();
            writer.close();
            System.out.println("Total Rows: " + count);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}