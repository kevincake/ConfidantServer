package com.springapp.mvc.controller;

import com.springapp.mvc.entities.UserEntity;
import com.springapp.mvc.service.UserService;
import com.springapp.mvc.util.PropertyUtil;
import com.springapp.mvc.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by glpublic on 2015/11/10.
 */
@Controller
@RequestMapping("/recharge")
public class RechargeController {
    @RequestMapping(value = "doCharge", method = RequestMethod.GET)
    public void doCharge(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String giftId = request.getParameter("giftId");
        String account = request.getParameter("account");
        String toAccount = request.getParameter("toAccount");
        String giftCount = request.getParameter("count");
        if (Util.isCorrect(giftId)) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("giftIdNullTips"));
            return;
        }
        if (Util.isCorrect(account)) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("accountNullTips"));
            return;
        }
        if (Util.isCorrect(toAccount)) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("accountNullTips"));
            return;
        }
        if (Util.isCorrect(giftCount)) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("giftCountNullTips"));
            return;
        }

        UserEntity user = UserService.getUserByAccount(account);
        if (user==null){

        }
        UserEntity toUser = UserService.getUserByAccount(toAccount);

        if (toUser==null){
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("giftToUserNull"));
            return;
        }

    }
}
