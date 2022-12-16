package com.simplon.bank_connect.client;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class clientController {

    @RequestMapping("/client")
    public String hello() {
        return "Hello World";
    }
}
