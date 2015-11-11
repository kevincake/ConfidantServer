package com.springapp.mvc.controller;

import com.google.gson.Gson;
import com.springapp.mvc.entities.ChatEntity;
import com.springapp.mvc.entities.UserEntity;
import com.springapp.mvc.model.SuccessMsg;
import com.springapp.mvc.service.ChatService;
import com.springapp.mvc.service.LoginService;
import com.springapp.mvc.service.RecommondService;
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
import java.util.List;

/**
 * Created by glpublic on 2015/11/9.
 */
@Controller
@RequestMapping("/recommond")
public class RecommondController {
    @RequestMapping(method = RequestMethod.GET)
    public void recommond(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        RecommondService service = new RecommondService();
        String time = request.getParameter("time");
        String pageNumStr = request.getParameter(Constants.PAGENUM);
        if (time == null || time.trim().equals("")) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("getRecommondTimeNull"));
            return;
        }
        if (pageNumStr == null || pageNumStr.trim().equals("")) {
            pageNumStr = "1";
        }

        int pageNum = Integer.parseInt(pageNumStr);
        List<UserEntity> recommondList = service.getRecommondList(Long.parseLong(time), pageNum, Constants.SqlListPageSize);
        Gson gson = new Gson();
        response.getWriter().write(SuccessMsg.getSuccessFormat(gson.toJson(recommondList)));
    }

    @RequestMapping(value = "getRecommondSearchResult", method = RequestMethod.GET)
    public void getRecommondBySearch(HttpServletRequest request, HttpServletResponse response) {
        RecommondService service = new RecommondService();
        String longtitudeStr = request.getParameter(Constants.LONGITUDE);
        String pageNumStr = request.getParameter(Constants.PAGENUM);
        String sexStr = request.getParameter(Constants.SEX);
        if (longtitudeStr == null || longtitudeStr.trim().equals("")) {
            longtitudeStr = "-1";
        }
        float longtitude = Float.parseFloat(longtitudeStr);
        String latitudeStr = request.getParameter(Constants.LATITUDE);
        if (latitudeStr == null || longtitudeStr.trim().equals("")) {
            latitudeStr = "-1";
        }
        if (pageNumStr == null || pageNumStr.trim().equals("")) {
            pageNumStr = "1";
        }
        if (sexStr == null || sexStr.trim().equals("")) {
            sexStr = "0";
        }
        int pageNum = Integer.parseInt(pageNumStr);
        int sex = Integer.parseInt(sexStr);
        float latitude = Float.parseFloat(latitudeStr);
        List<UserEntity> entities = service.getRecommondListBySearch(latitude, longtitude, sex, pageNum, Constants.SqlListPageSize);
        try {
            response.getWriter().write(SuccessMsg.getSuccessFormat(new Gson().toJson(entities)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //获取文字聊天推荐,如果另外一个用户也正在进行文字匹配
    @RequestMapping(value = "getRecommondUser", method = RequestMethod.GET)
    public void getRecommondUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userIdStr = request.getParameter("userId");
        String chatTypeStr = request.getParameter("chatType");
        //判断参数是否合法
        if (userIdStr == null || userIdStr.trim().equals("") || chatTypeStr == null || chatTypeStr.trim().equals("")) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("paramErrorTips"));
            return;
        }
        //判断是否登录
        int userId = Integer.parseInt(userIdStr);
        int chatType = Integer.parseInt(chatTypeStr);
        if (LoginService.isLogin(userId)) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("notLoginTips"));
            return;
        }
        //获取匹配
        RecommondService service = new RecommondService();
        UserEntity user = service.getRecommondTUser(userId, chatType);
        if (user == null) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("recommodErrorTips"));
            return;
        }
        try {
            response.getWriter().write(SuccessMsg.getSuccessFormat(new Gson().toJson(user)));
            ChatEntity chat = ChatService.getChatByUserId(userId);
            chat.setChatType(chatType);
            ChatService.updateChat(chat);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
