package com.mohsin.mockito_demo;

import com.mohsin.mockito_demo.business.BusinessService;
import com.mohsin.mockito_demo.business.LocalBusinessService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LocalBusinessServiceMockTest {

    @Mock
    private BusinessService mockBusinessService;

    @InjectMocks
    private LocalBusinessService localBusinessService;

    @Test
    void findGreatest_ThreeMemberArray() {
        when(mockBusinessService.getAllData()).thenReturn(new int[]{10, 15, 99});
        var value = localBusinessService.findGreatest();
        assertEquals(99, value);
    }

    @Test
    void findGreatest_EmptyArray() {
        when(mockBusinessService.getAllData()).thenReturn(new int[]{});
        var value = localBusinessService.findGreatest();
        assertEquals(Integer.MIN_VALUE, value);
    }
}
