package com.example.technical_test.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FutureTransactionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String clientType;
    private String clientNumber;
    private String accountNumber;
    private String subAccountNumber;
    private String exchangeCode;
    private String productGroupCode;
    private String symbol;
    private String expirationDate;
    private String totalTransactionAmount;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getClientNumber() {
        return clientNumber;
    }
    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }


}
