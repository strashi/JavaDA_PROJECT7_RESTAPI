package com.nnk.springboot.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "trades")
public class Trade {
    // TODO: Map columns in data table TRADE with corresponding java fields
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer tradeId;
    private String account;
    private String type;
    @Digits(integer = 10, fraction = 2)
    private Double buyQuantity;
    @Digits(integer = 10, fraction = 2)
    private Double sellQuantity;
    @Digits(integer = 10, fraction = 2)
    private Double buyPrice;
    @Digits(integer = 10, fraction = 2)
    private Double sellPrice;
    private String benchmark;
    private Timestamp tradeDate;
    private String security;
    private String status;
    private String trader;
    private String book;
    private String creationName;
    private Timestamp creationDate;
    private String revisionName;
    private Timestamp revisionDate;
    private String dealName;
    private String dealType;
    private String sourceListId;
    private String side;

    public Trade() {
    }

    public Trade(Integer tradeId, String account, String type) {
        this.tradeId = tradeId;
        this.account = account;
        this.type = type;
    }


}
