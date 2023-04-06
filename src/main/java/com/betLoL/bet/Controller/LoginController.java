package com.betLoL.bet.Controller;

import com.betLoL.bet.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/Login")
    public String Login(){
        return "Login";
    }


}
