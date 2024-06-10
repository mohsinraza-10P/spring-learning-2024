package com.mohsin.restful_web_services.filtering;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        var bean = new SomeBean("value1", "value2", "value3");
        return getSomeBeanFilteredMappingJacksonValue(bean, "field1", "field3");
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList() {
        List<SomeBean> list = Arrays.asList(
                new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6")
        );
        return getSomeBeanFilteredMappingJacksonValue(list, "field2", "field3");
    }

    private MappingJacksonValue getSomeBeanFilteredMappingJacksonValue(Object data, String... fields) {
        var mappingJacksonValue = new MappingJacksonValue(data);
        var propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
        var filterProvider = new SimpleFilterProvider()
                .addFilter("SimpleBeanFilter", propertyFilter);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }
}
