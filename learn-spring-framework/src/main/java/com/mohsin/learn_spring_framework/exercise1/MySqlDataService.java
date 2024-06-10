package com.mohsin.learn_spring_framework.exercise1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class MySqlDataService implements DataService {
    @Override
    public int[] fetchData() {
        return new int[]{1, 2, 3, 4, 5};
    }
}
