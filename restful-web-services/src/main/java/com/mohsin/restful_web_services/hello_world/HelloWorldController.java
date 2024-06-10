package com.mohsin.restful_web_services.hello_world;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World!");
    }

    @GetMapping("/hello-world/path-var/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable("name") String name) {
        return new HelloWorldBean(String.format("Hello World %s", name));
    }

    @GetMapping("/hello-world-internationalized")
    public HelloWorldBean helloWorldInternationalized() {
        var locale = LocaleContextHolder.getLocale();
        var localizedMsg = messageSource.getMessage("good.morning.message", null, null, locale);
        return new HelloWorldBean(String.format("Hello, %s!", localizedMsg));
    }
}
