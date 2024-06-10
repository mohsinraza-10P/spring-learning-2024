package com.mohsin.learn_spring_framework.exercise1;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessCalcService {
    private final DataService dataService;

    public BusinessCalcService(DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays.stream(dataService.fetchData()).max().orElse(-1);
    }
}
