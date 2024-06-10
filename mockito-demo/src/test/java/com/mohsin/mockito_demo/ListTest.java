package com.mohsin.mockito_demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    void simpleTest() {
        var mockList = mock(List.class);
        when(mockList.size()).thenReturn(3);
        assertEquals(3, mockList.size());
    }

    @Test
    void multipleReturnsTest() {
        var mockList = mock(List.class);
        when(mockList.size()).thenReturn(1).thenReturn(2);
        assertEquals(1, mockList.size());
        assertEquals(2, mockList.size());
    }

    @Test
    void specificParametersTest() {
        var mockList = mock(List.class);
        when(mockList.get(0)).thenReturn("Item0");
        assertEquals("Item0", mockList.get(0));
        assertNull(mockList.get(1));
    }

    @Test
    void genericParametersTest() {
        var mockList = mock(List.class);
        when(mockList.get(Mockito.anyInt())).thenReturn("ItemAny");
        assertEquals("ItemAny", mockList.get(45));
    }
}
