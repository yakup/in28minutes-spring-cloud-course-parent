package com.in28minutes.course.masterspringcloud.currencyexchanger.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class ExchangeValue {
    @Id
    private Long id;
    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")
    private String to;
    private BigDecimal conversionMultiple;
    private Integer port;

}
