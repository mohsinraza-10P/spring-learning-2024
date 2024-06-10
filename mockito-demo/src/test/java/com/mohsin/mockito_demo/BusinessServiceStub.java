package com.mohsin.mockito_demo;

import com.mohsin.mockito_demo.business.BusinessService;

public class BusinessServiceStub implements BusinessService {
    @Override
    public int[] getAllData() {
        return new int[]{10, 15, 99};
    }
}
