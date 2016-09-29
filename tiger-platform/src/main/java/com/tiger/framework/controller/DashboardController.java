package com.tiger.framework.controller;

import com.tiger.framework.dao.tk.ShiroUserMapper;
import com.tiger.framework.datamodel.ShiroUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
