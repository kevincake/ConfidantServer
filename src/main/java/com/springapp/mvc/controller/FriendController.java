package com.springapp.mvc.controller;

import com.google.gson.Gson;
import com.springapp.mvc.entities.FriendEntity;
import com.springapp.mvc.entities.UserEntity;
import com.springapp.mvc.model.SuccessMsg;
import com.springapp.mvc.service.FriendService;
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
 * Created by glpublic on 2015/11/5.
 */
@Controller
@RequestMapping("/friend")
public class FriendController {
    //获取所有的好友
    @RequestMapping(value = "/getFriends",method = RequestMethod.GET)
    public void getFriends(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        FriendService service = new FriendService();
        String userId = request.getParameter("userId");
        if (userId==null){
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("getFriendListErrorTips"));
            return;
        }
        List<FriendEntity> friends = service.getFriends(Integer.parseInt(userId));
        Gson gson = new Gson();
        response.getWriter().write(SuccessMsg.getSuccessFormat(gson.toJson(friends)));
    }
    //添加好友
    @RequestMapping(value = "/addFriend",method = RequestMethod.GET)
    public void addFriend(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        FriendService service = new FriendService();
        String userId = request.getParameter("userId");
        String friendId = request.getParameter("friendId");
        if (userId==null||friendId==null){
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("addFriendErrorTips"));
            return;
        }
        if (service.isFriendExist(Integer.parseInt(userId),Integer.parseInt(friendId))){
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("addFriendExistTips"));
            return;
        }
       UserEntity user =  service.addFriend(Integer.parseInt(userId), Integer.parseInt(friendId));
        response.getWriter().write(SuccessMsg.getSuccessFormat(new Gson().toJson(user)));
    }
    //删除好友
    @RequestMapping(value = "/deleteFriend",method = RequestMethod.GET)
    public void deleteFriend(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        FriendService service = new FriendService();
        String userId = request.getParameter("userId");
        String friendId = request.getParameter("friendId");
        if (userId==null||friendId==null){
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("deleteFriendErrorTips"));
            return;
        }
        service.deleteFriend(Integer.parseInt(userId), Integer.parseInt(friendId));
        response.getWriter().write(SuccessMsg.getSuccessFormat(friendId));

    }
    //移动好友到黑名单
    @RequestMapping(value = "/blackFriend",method = RequestMethod.GET)
    public void blackFriend(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        FriendService service = new FriendService();
        String userId = request.getParameter("userId");
        String friendId = request.getParameter("friendId");
        if (userId==null||friendId==null){
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("deleteFriendErrorTips"));
            return;
        }
        service.blackFriend(Integer.parseInt(userId), Integer.parseInt(friendId));
        response.getWriter().write(SuccessMsg.getSuccessFormat(friendId));
    }
    //黑名单列表
    @RequestMapping(value = "/getBlackFriendList",method = RequestMethod.GET)
    public void getBlackFriendList(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("userId");
        String friendId = request.getParameter("friendId");
        if (userId==null||friendId==null){
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("deleteFriendErrorTips"));
            return;
        }
//        service.blackFriend(Integer.parseInt(userId), Integer.parseInt(friendId));
    }
    
    //获取分页好友

}