package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class StaffManager {

    @GetMapping
    public ModelAndView homepage(){
        return new ModelAndView("/manager/list");
    }
}
