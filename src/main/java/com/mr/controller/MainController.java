package com.mr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ydd on 2018/5/22.
 */
@Controller
public class MainController {

    @RequestMapping("/main")
    public String toMainPage(){
        return "main";
    }


}
