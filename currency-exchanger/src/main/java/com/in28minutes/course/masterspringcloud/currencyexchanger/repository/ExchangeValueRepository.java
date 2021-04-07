package com.in28minutes.course.masterspringcloud.currencyexchanger.repository;

import com.in28minutes.course.masterspringcloud.currencyexchanger.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
    ExchangeValue findByFromAndTo(String from, String to);
}
