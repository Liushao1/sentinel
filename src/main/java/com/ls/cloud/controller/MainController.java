package com.ls.cloud.controller;

import com.ls.cloud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    PersonService personService;

    @GetMapping("get1")
    public String get1(){

        return personService.getBody1();
    }

    @GetMapping("get2")
    public String get2(){

        return personService.getBody2();
    }
}
