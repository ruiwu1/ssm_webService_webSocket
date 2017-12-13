package com.webservice.controller;

import com.webservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/showUser")
    @ResponseBody
    public String toIndex(HttpServletRequest request, Model model) {
        int contTest = userService.selectContTest();
        return contTest+"";
    }
}
