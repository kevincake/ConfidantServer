package com.springapp.mvc.controller;

import com.google.gson.Gson;
import com.springapp.mvc.dao.DBUtils;
import com.springapp.mvc.entities.UserEntity;
import com.springapp.mvc.model.Base;
import com.springapp.mvc.model.ErrMsg;
import com.springapp.mvc.model.SuccessMsg;
import com.springapp.mvc.model.User;
import com.springapp.mvc.service.RigsterService;
import com.springapp.mvc.util.PropertyUtil;
import com.springapp.mvc.util.Util;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

/**
 * Created by glpublic on 2015/11/3.
 */
@Controller
@RequestMapping("/register")
public class RigsterController {
    @RequestMapping(method = RequestMethod.GET)
    public void register(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        String habbit = request.getParameter("habbit");
        String friends = request.getParameter("friends");
        String account = request.getParameter("accout");
        String sexParam = request.getParameter("sex");
         if (sexParam==null){

             Util.writeErrorMsg2Client(response,PropertyUtil.getProperty("sexTips"));
             return;
         }
         int sex = Integer.parseInt(sexParam);
         float longtitude = Float.parseFloat(request.getParameter("longtitude"));
         float latitude = Float.parseFloat(request.getParameter("latitude"));
         UserEntity user = new UserEntity();
         user.setAccount(account);
         user.setUserName(userName);
         user.setPassword(password);
         user.setBirthday(birthday);
         user.setHabbit(habbit);
         user.setFriends(friends);
         user.setLongitude(longtitude);
         user.setLatitude(latitude);
         user.setSex(sex);
 
         RigsterService service = new RigsterService();
         if (service.isUserNameExist(user.getUserName())) {
             Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("userNameTips"));
             return;
         }
         // 手机号是否合法
         if (user.getAccount().length() != 11 && !RigsterService.checkMobile(user.getAccount())) {
             Util.writeErrorMsg2Client(response,  PropertyUtil.getProperty("mobileNumTips"));
             return;
         }
          //密码是否合法
         if (!RigsterService.checkUserPasswordLength(user.getPassword())) {
             Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("passwordTips"));
             return;
         }
         service.saveUser(user);
 
         try {
             Gson gson = new Gson();
             response.getWriter().write(SuccessMsg.getSuccessFormat(gson.toJson(user)));
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
}
