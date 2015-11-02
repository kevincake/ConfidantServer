package com.springapp.mvc.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public void printWelcome(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().write("hello world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}