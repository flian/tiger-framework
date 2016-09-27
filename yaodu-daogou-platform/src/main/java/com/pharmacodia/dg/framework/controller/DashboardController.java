package com.pharmacodia.dg.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by foy on 2016-06-14.
 */
@Controller
public class DashboardController {

    @RequestMapping("/index")
    public String dashboard(){
        return "homepage/home";
    }
}
