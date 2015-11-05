package com.springapp.mvc.controller;

import com.google.gson.Gson;
import com.springapp.mvc.entities.UserEntity;
import com.springapp.mvc.model.SuccessMsg;
import com.springapp.mvc.service.LoginService;
import com.springapp.mvc.util.PropertyUtil;
import com.springapp.mvc.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by glpublic on 2015/11/5.
 */
@Controller
@RequestMapping("/friend")
public class FriendController {
    //获取所有的好友
    @RequestMapping(value = "/getFriends",method = RequestMethod.GET)
    public void getFriends(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("userId");


    }
    
    //获取分页好友

}