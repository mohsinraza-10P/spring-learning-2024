package com.mohsin.learn_spring_framework.exercise1;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class MongoDbDataService implements DataService {
    @Override
    public int[] fetchData() {
        return new int[] {11, 22, 33, 44, 55};
    }
}
