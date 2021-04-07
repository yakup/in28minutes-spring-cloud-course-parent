package com.in28minutes.course.masterspringcloud.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.in28minutes.course.masterspringcloud.controller.filter.DynamicallyFilteredBean;
import com.in28minutes.course.masterspringcloud.controller.model.FilteredBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    private static final List<FilteredBean> FILTERED_BEANS = Arrays.asList(new FilteredBean("value1", "value2", "value3"),
            new FilteredBean("value4", "value5", "value6"),
            new FilteredBean("value7", "value8", "value9"));

    @GetMapping("/filtered-bean")
    public FilteredBean getFilteredBean() {
        return new FilteredBean("value10", "value11", "value12");
    }

    @GetMapping("/dynamic-filtered-bean")
    public MappingJacksonValue getDynamicallyFilteredBean() {
        DynamicallyFilteredBean bean = new DynamicallyFilteredBean("value0", "value1", "value2", "value3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field4");

        FilterProvider filters = new SimpleFilterProvider().addFilter("FilteredBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(bean);
        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/filtered-beans")
    public List<FilteredBean> getFilteredBeans() {
        return FILTERED_BEANS;
    }
}
