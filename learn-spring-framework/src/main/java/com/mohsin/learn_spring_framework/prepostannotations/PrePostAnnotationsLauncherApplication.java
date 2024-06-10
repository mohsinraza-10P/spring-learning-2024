package com.mohsin.learn_spring_framework.prepostannotations;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All dependencies are ready!");
    }

    // Get executed as soon as the dependencies are initialized by Spring
    @PostConstruct
    public void onInit() {
        someDependency.ready();
    }

    // Get executed before the application terminates
    @PreDestroy
    public void onDestroy() {
        System.out.println("Resources released now!");
    }
}

@Component
class SomeDependency {

    public void ready() {
        System.out.println("SomeDependency is ready to use now!");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationsLauncherApplication {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationsLauncherApplication.class)) {
            var beans = context.getBeanDefinitionNames();
            Arrays.stream(beans).forEach(System.out::println);
        }
    }
}
