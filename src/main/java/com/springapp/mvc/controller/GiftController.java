package com.springapp.mvc.controller;

import com.springapp.mvc.entities.GiftEntity;
import com.springapp.mvc.entities.UserEntity;
import com.springapp.mvc.service.GiftService;
import com.springapp.mvc.service.UserService;
import com.springapp.mvc.util.PropertyUtil;
import com.springapp.mvc.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/gift")
/**
 * Created by glpublic on 2015/11/10.
 */
public class GiftController {
    @RequestMapping(value = "sendGift", method = RequestMethod.GET)
    public void doCharge(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String giftId = request.getParameter("giftId");
        String account = request.getParameter("account");
        String toAccount = request.getParameter("toAccount");
        String giftCount = request.getParameter("count");
        if (!Util.isCorrect(giftId)) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("giftIdNullTips"));
            return;
        }
        if (!Util.isCorrect(account)) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("accountNullTips"));
            return;
        }
        if (!Util.isCorrect(toAccount)) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("accountNullTips"));
            return;
        }
        if (!Util.isCorrect(giftCount)) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("giftCountNullTips"));
            return;
        }
        UserEntity user = UserService.getUserByAccount(account);
        if (user == null) {

        }
        UserEntity toUser = UserService.getUserByAccount(toAccount);

        if (toUser == null) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("giftToUserNull"));
            return;
        }
        int giftNum = Integer.parseInt(giftCount);
        //判断数量是否足够
        GiftEntity queryEntiey = GiftService.queryGift(Integer.parseInt(giftId), account);
        GiftEntity toAccountEntity = GiftService.queryGift(Integer.parseInt(giftId), toAccount);
        if (queryEntiey == null || queryEntiey.getCount() < giftNum) {
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("giftNumNotEnough"));
            return;
        }
        GiftService service = new GiftService();
        //如果数量够,剪掉送掉的礼物，然后更新数据库

        //给被赠送的用户加上礼物
        if (toAccountEntity == null) {
            GiftEntity toEntity = new GiftEntity();
            toEntity.setAccount(toAccount);
            toEntity.setItemId(Integer.parseInt(giftId));
            toEntity.setCount(giftNum);
            service.saveGift(toEntity);
        } else {
            toAccountEntity.setCount(toAccountEntity.getCount() + giftNum);
            queryEntiey.setCount(queryEntiey.getCount() - giftNum);
            service.updateGift(toAccountEntity);
        }
        service.updateGift(queryEntiey);
    }
}
