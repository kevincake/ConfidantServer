package com.springapp.mvc.controller;

import com.springapp.mvc.service.BlogService;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by glpublic on 2015/11/11.
 */
@RequestMapping("/blog")
public class BlogController {
    public void getBolgListByUserId(int userId){
        BlogService service = new BlogService();
        
    }
}
