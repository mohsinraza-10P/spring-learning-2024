package com.mohsin.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("v1/person")
    public PersonV1 getPersonV1Url() {
        return new PersonV1("Mohsin");
    }

    @GetMapping("v2/person")
    public PersonV2 getPersonV2Url() {
        return new PersonV2(new Name("Mohsin", "Raza"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getPersonV1Param() {
        return new PersonV1("Mohsin");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getPersonV2Param() {
        return new PersonV2(new Name("Mohsin", "Raza"));
    }

    @GetMapping(path = "/person", headers = "x-api-version=1")
    public PersonV1 getPersonV1Header() {
        return new PersonV1("Mohsin");
    }

    @GetMapping(path = "/person", headers = "x-api-version=2")
    public PersonV2 getPersonV2Header() {
        return new PersonV2(new Name("Mohsin", "Raza"));
    }

    @GetMapping(path = "/person", produces = "application/vnd.api-v1+json")
    public PersonV1 getPersonV1ContentNegotiation() {
        return new PersonV1("Mohsin");
    }

    @GetMapping(path = "/person", produces = "application/vnd.api-v2+json")
    public PersonV2 getPersonV2ContentNegotiation() {
        return new PersonV2(new Name("Mohsin", "Raza"));
    }

}
