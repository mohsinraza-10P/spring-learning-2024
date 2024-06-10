package com.mohsin.learn_spring_framework.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class MyBusinessClass {
    // Field injection
    // @Autowired
    Dependency1 dependency1;
    // @Autowired
    Dependency2 dependency2;

    @Autowired
    public MyBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("Constructor injection");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    // Setter injection
    // @Autowired
    public void setDependency1(Dependency1 dependency1) {
        System.out.println("Setter injection - " + dependency1);
        this.dependency1 = dependency1;
    }

    // @Autowired
    public void setDependency2(Dependency2 dependency2) {
        System.out.println("Setter injection - " + dependency2);
        this.dependency2 = dependency2;
    }

    @Override
    public String toString() {
        return "MyBusinessClass[" +
                "dependency1=" + dependency1 +
                ", dependency2=" + dependency2 +
                ']';
    }
}

@Component
class Dependency1 {
    @Override
    public String toString() {
        return Dependency1.class.getSimpleName();
    }
}

@Component
class Dependency2 {
    @Override
    public String toString() {
        return Dependency2.class.getSimpleName();
    }
}

@Configuration
@ComponentScan
public class DIAppLauncherApplication {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(DIAppLauncherApplication.class)) {
            var beans = context.getBeanDefinitionNames();
            Arrays.stream(beans).forEach(System.out::println);

            System.out.println(context.getBean(MyBusinessClass.class));
        }
    }
}
