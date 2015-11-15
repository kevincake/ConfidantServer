package com.springapp.mvc.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.springapp.mvc.entities.ChatEntity;
import com.springapp.mvc.entities.UserEntity;
import com.springapp.mvc.model.SuccessMsg;
import com.springapp.mvc.netResult.TokenResult;
import com.springapp.mvc.service.ChatService;
import com.springapp.mvc.service.RigsterService;
import com.springapp.mvc.service.UserService;
import com.springapp.mvc.util.Constants;
import com.springapp.mvc.util.PropertyUtil;
import com.springapp.mvc.util.Util;
import io.rong.ApiHttpClient;
import io.rong.models.FormatType;
import io.rong.models.SdkHttpResult;
import io.rong.util.GsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.BindException;

/**
 * Created by glpublic on 2015/11/3.
 */
@Controller
@RequestMapping("/register")
public class RigsterController {
    @RequestMapping(method = RequestMethod.POST)
    public void register(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        String habbit = request.getParameter("habbit");
        String friends = request.getParameter("friends");
        String account = request.getParameter("account");
        String sexParam = request.getParameter("sex");
//        String headIconContent = request.getParameter("headIcon");

        if (sexParam == null) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("sexTips"));
            return;
        }
        int sex = Integer.parseInt(sexParam);
        String longtitudeStr = request.getParameter("longtitude");
        if (longtitudeStr == null) {
            longtitudeStr = "-1";
        }
        float longtitude = Float.parseFloat(longtitudeStr);
        String latitudeStr = request.getParameter("latitude");
        if (latitudeStr == null) {
            latitudeStr = "-1";
        }
        float latitude = Float.parseFloat(latitudeStr);
        UserEntity user = new UserEntity();
        user.setAccount(account);
        user.setUserName(userName);
        user.setPassword(password);
        user.setBirthday(birthday);
        user.setHabbit(habbit);
//        user.setFriends(friends);
        user.setLongitude(longtitude);
        user.setLatitude(latitude);
        user.setSex(sex);

        RigsterService service = new RigsterService();
        String headIconPath = service.saveHeadIcon(request);
        user.setHeadIcon(headIconPath);
        if (user.getUserName() == null || user.getUserName().trim().length() == 0) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("userNameNullTips"));
            return;
        }
        if (service.isUserNameExist(user.getUserName())) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("userNameTips"));
            return;
        }
        //手机号是否为
        if (user.getAccount() == null || user.getAccount().trim().length() == 0) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("accountNullTips"));
            return;
        }
        // 手机号是否合法
        if (user.getAccount().length() != 11) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("mobileNumTips"));
            return;
        }
        if (service.isAccountExist(user.getAccount())) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("accountExistTips"));
            return;

        }
        if (user.getPassword() == null) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("passwordNullTips"));
            return;
        }
        //密码是否合法
        if (!RigsterService.checkUserPasswordLength(user.getPassword())) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("passwordTips"));
            return;
        }
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest
                .getFile("fileUpload");


        //生成Token
        SdkHttpResult result = null;

        try {
            result = ApiHttpClient.getToken(Constants.APPKEY, Constants.APPSECRET, user.getAccount(), user.getUserName(),
                   "http://www.baidu.com", FormatType.json);
        } catch (Exception e) {
            System.out.print("gettoken error");
            e.printStackTrace();
        }
//        GsonUtil.fromJson()
//        Gson son = new Gson();


        String resultResult = result.getResult();
        Gson son = new Gson();
        TokenResult tokenResult= son.fromJson(resultResult, TokenResult.class);
        user.setToken(tokenResult.getToken());

//        JsonObject obj = new JSONObject(resultResult);
        if (tokenResult==null){
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("getTokenError"));
            return;

        }


        ChatEntity chat = new ChatEntity();
//        chat.setUserId(user.getAccount());
//        UserEntity userByAccount = UserService.getUserByAccount(user.getAccount());
        chat.setAccount(user.getAccount());
        chat.setToken(tokenResult.getToken());
        ChatService.saveChat(chat);


        service.saveUser(user);
        try {
            Gson gson = new Gson();
            response.getWriter().write(SuccessMsg.getSuccessFormat(gson.toJson(user)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void onSubmit(HttpServletRequest request,
                                 HttpServletResponse response, BindException errors)
            throws Exception {

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest
                .getFile("fileUpload");

        String name = multipartRequest.getParameter("hello");
        System.out.println("name: " + name);
        // 获得文件名：
        String realFileName = file.getOriginalFilename();
        System.out.println("获得文件名：" + realFileName);
        // 获取路径
        String ctxPath = request.getSession().getServletContext().getRealPath(
                "/")
                + "images/";
        // 创建文件
        File dirPath = new File(ctxPath);
        if (!dirPath.exists()) {
            dirPath.mkdir();
        }
        File uploadFile = new File(ctxPath + realFileName);
        FileCopyUtils.copy(file.getBytes(), uploadFile);
//        request.setAttribute("files", loadFiles(request));
//        return new ModelAndView("success");
    }

}
