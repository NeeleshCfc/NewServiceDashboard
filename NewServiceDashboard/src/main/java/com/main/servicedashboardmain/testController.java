package com.main.servicedashboardmain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class testController {


    @RequestMapping("/HelloWorld")
    public ModelAndView firstPage() {
        return new ModelAndView("index");
    }

}