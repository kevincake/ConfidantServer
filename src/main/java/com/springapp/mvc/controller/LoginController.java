package com.springapp.mvc.controller;

import com.google.gson.Gson;
import com.springapp.mvc.entities.ChatEntity;
import com.springapp.mvc.entities.UserEntity;
import com.springapp.mvc.model.SuccessMsg;
import com.springapp.mvc.netResult.TokenResult;
import com.springapp.mvc.service.ChatService;
import com.springapp.mvc.service.LoginService;
import com.springapp.mvc.service.UserService;
import com.springapp.mvc.util.Constants;
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
 * Created by glpublic on 2015/11/3.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping(method = RequestMethod.GET)
    public void login(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        LoginService service = new LoginService();
        if (account == null || password == null) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("loginerrorTips"));
            return;
        }
        UserEntity user = service.getUser(account, password);
        if (user == null) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("loginUserNotExist"));
            return;
        }
        ;
        user.setLastlogintime(System.currentTimeMillis() + "");
        user.setIsLogin(Constants.RESULT_TRUE);




//

//        //生成Token
//        SdkHttpResult result = null;
//        String headIcon = "http://b168.photo.store.qq.com/psb?/V11j3jCT2FAMTw/GvxefL4njb6tL*q7mzkZIEwOcG06j6sHptBzKYE0cfM!/b/dA3*LmT*JQAA&bo=gAJVAwAAAAABB*Q!&rf=viewer_4";
//        try {
//            result = ApiHttpClient.getToken(Constants.APPKEY, Constants.APPSECRET, user.getAccount(), user.getUserName(),
//                    headIcon, FormatType.json);
//        } catch (Exception e) {
//            System.out.print("gettoken error");
//            e.printStackTrace();
//        }

//        String resultResult = result.getResult();
//        Gson son = new Gson();
//        TokenResult tokenResult = son.fromJson(resultResult, TokenResult.class);
//        user.setToken(tokenResult.getToken());
//
//        if (tokenResult == null) {
//            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("getTokenError"));
//            return;
//        }
        UserService.updateUser(user);

        Gson gson = new Gson();
        response.getWriter().write(SuccessMsg.getSuccessFormat(gson.toJson(user)));
    }

    @RequestMapping(value = "loginOut", method = RequestMethod.GET)
    public void loginOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LoginService service = new LoginService();
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        UserEntity user = service.getUser(account, password);
        if (user == null) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("loginUserNotExist"));
            return;
        }
        ;
        user.setIsLogin(Constants.RESULT_FALSE);

        Gson gson = new Gson();
        UserService.updateUser(user);
        response.getWriter().write(SuccessMsg.getSuccessFormat(gson.toJson(user)));

    }


}
