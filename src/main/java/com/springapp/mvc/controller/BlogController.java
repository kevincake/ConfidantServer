package com.springapp.mvc.controller;

import com.springapp.mvc.service.BlogService;
import com.springapp.mvc.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;

/**
 * Created by glpublic on 2015/11/11.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
    @RequestMapping(value = "/deployBlog",method = RequestMethod.POST)
    public void deployBlog( HttpServletRequest request, HttpServletResponse response){
        String account = request.getParameter(Constants.ACCOUNT_KEY);
        String title = request.getParameter("title");

        BlogService service = new BlogService();

        
    }
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public void test( HttpServletRequest request, HttpServletResponse response){
//        String filePath = "";

        URL url = BlogController.class.getResource("BlogController.class");

        String className = url.getFile();

       String filePath = className.substring(0,className.indexOf("WEB-INF") + "WEB-INF".length());
       System.out.print(filePath);
//        return filePath;
    }
}
