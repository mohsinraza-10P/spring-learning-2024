package com.mohsin.mockito_demo;

import com.mohsin.mockito_demo.business.LocalBusinessService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalBusinessServiceStubTest {

    @Test
    void stubTest() {
        var businessService = new BusinessServiceStub();
        var localBusinessService = new LocalBusinessService(businessService);
        var value = localBusinessService.findGreatest();
        assertEquals(99, value);
    }
}
