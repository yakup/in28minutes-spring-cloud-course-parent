package com.in28minutes.course.masterspringcloud.controller.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Getter
@Setter
public class LimitConfiguration {
    int maximum;
    int minimum;

    protected LimitConfiguration() {

    }
}
