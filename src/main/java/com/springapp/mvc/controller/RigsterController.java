package com.springapp.mvc.controller;

import com.google.gson.Gson;
import com.springapp.mvc.dao.DBUtils;
import com.springapp.mvc.entities.UserEntity;
import com.springapp.mvc.model.Base;
import com.springapp.mvc.model.ErrMsg;
import com.springapp.mvc.model.User;
import com.springapp.mvc.service.RigsterService;
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
        Session session = DBUtils.getSession();
//        List<UserEntity> list = session.createCriteria(UserEntity.class).list();
        UserEntity user = new UserEntity();
        user.setBirthday("1992.11.04");
        user.setAccount("11111111111");
        user.setFriends("123#345");
        user.setUserName("andy");
        user.setHabbit("swim");
        user.setHeadIcon("http://www.baidu.com");
        user.setPassword("111111");
        user.setLongitude(10);
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();

        RigsterService service = new RigsterService();
        if (service.isUserNameExist(user.getUserName())) {
            ErrMsg msg = new ErrMsg();
            msg.setResult(0);
            msg.setErrno("用户已经存在");
            Util.writeObj2Clicent(response, msg);
            return;
        }
        //手机号是否合法
        if (user.getAccount().length()!=11&& !RigsterService.checkMobile(user.getAccount())){
            ErrMsg msg = new ErrMsg();
            msg.setResult(0);
            msg.setErrno("手机号不合法");
            Util.writeObj2Clicent(response,msg);
            return;
        }
        //密码是否合法
        if (!RigsterService.checkUserPasswordLength(user.getPassword())){
            ErrMsg msg = new ErrMsg();
            msg.setResult(0);
            msg.setErrno("密码不合法");
            Util.writeObj2Clicent(response,msg);
            return;
        }
//        for(UserEntity admin:list) {
//            System.out.println(admin.getUserName());
//        }
//        for (int i = 1; i <list.size() ; i++) {
//
//            System.out.print("===="+list.get(i));
//            System.out.print(list.get(i).getUserName());
//        }



        String userName = request.getParameter("userName");
        try {
//            UserEntity user = new UserEntity();
            Gson gson = new Gson();
            response.getWriter().write(gson.toJson(user));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
