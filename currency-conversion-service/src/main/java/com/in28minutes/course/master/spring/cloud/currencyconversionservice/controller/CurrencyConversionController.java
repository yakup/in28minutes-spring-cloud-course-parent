package com.in28minutes.course.master.spring.cloud.currencyconversionservice.controller;

import com.in28minutes.course.master.spring.cloud.currencyconversionservice.CurrencyExchangeServiceProxy;
import com.in28minutes.course.master.spring.cloud.currencyconversionservice.model.CurrencyConversionBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {
    private CurrencyExchangeServiceProxy proxy;

    public CurrencyConversionController(CurrencyExchangeServiceProxy proxy) {
        this.proxy = proxy;
    }

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);

        CurrencyConversionBean response = responseEntity.getBody();
        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), 0);
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        CurrencyConversionBean currencyConversionBean = proxy.retrieveExchangeValue(from, to);

        return new CurrencyConversionBean(currencyConversionBean.getId(), from, to, currencyConversionBean.getConversionMultiple(), quantity, quantity.multiply(currencyConversionBean.getConversionMultiple()), 0);
    }
}
