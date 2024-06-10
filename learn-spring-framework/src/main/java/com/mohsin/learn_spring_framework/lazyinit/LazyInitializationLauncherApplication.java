package com.mohsin.learn_spring_framework.lazyinit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA {
    public String title() {
        return "I'm class A.";
    }
}

@Component
@Lazy // Tells spring to initialize only when it is accessed
class ClassB {
    private final ClassA classA;

    public ClassB(ClassA classA) {
        System.out.println("Initialization of ClassB done.");
        this.classA = classA;
    }

    public String title() {
        return "I'm class B.";
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)) {
            System.out.println(context.getBean(ClassA.class).title());
            System.out.println(context.getBean(ClassB.class).title());
        }
    }
}
