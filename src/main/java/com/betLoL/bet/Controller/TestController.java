package com.betLoL.bet.Controller;

import com.betLoL.bet.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/Test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/Test")
    public String Test(){
        return testService.Test();
    }
}
