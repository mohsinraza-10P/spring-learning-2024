package com.mohsin.mockito_demo.business;

public class LocalBusinessService {

    private final BusinessService businessService;

    public LocalBusinessService(BusinessService businessService) {
        this.businessService = businessService;
    }

    public int findGreatest() {
        var data = businessService.getAllData();
        int greatestValue = Integer.MIN_VALUE;
        for (int value : data) {
            if (value > greatestValue) {
                greatestValue = value;
            }
        }
        return greatestValue;
    }
}
