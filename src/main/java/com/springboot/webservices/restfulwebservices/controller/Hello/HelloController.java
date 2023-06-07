package com.springboot.webservices.restfulwebservices.controller.Hello;


import com.springboot.webservices.restfulwebservices.Model.Hello.HelloWorldBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path = "/hello")
    public String HelloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world")
    public HelloWorldBean HelloBeanWorld(){
        return new HelloWorldBean("Hello World");
    }
}
