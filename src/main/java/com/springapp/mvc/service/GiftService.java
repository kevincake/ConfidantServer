package com.springapp.mvc.service;

import com.springapp.mvc.dao.DBUtils;
import com.springapp.mvc.entities.ChatEntity;
import com.springapp.mvc.entities.GiftEntity;
import com.springapp.mvc.entities.UserEntity;
//import com.springapp.mvc.model.Gift;
import com.springapp.mvc.util.Constants;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by glpublic on 2015/11/11.
 */
public class GiftService {
    public static GiftEntity saveGift(GiftEntity chat){
        Session session = DBUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(chat);
        transaction.commit();
        return chat;
    }

    public static GiftEntity deleteGift(GiftEntity chat){
        Session session = DBUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(chat);
        transaction.commit();
        return chat;
    }
    //判断用户有没有这个礼物
    public static GiftEntity queryGift(int giftId,String account) {
        Session session = DBUtils.getSession();
        Criteria c = session.createCriteria(UserEntity.class);
        c.add(Restrictions.eq("itemId", giftId));//eq是等于，gt是大于，lt是小于,or是或
        c.add(Restrictions.eq(Constants.ACCOUNT_KEY, account));
        List<GiftEntity> list = c.list();
        if (list != null && list.size() > 0) {
            return null;
        }
        return list.get(Constants.SqlListDefaultIndex);
    }
    public static GiftEntity updateGift(GiftEntity gift){
        Session session = DBUtils.getSession();
        session.saveOrUpdate(gift);
        return gift;
    }
}
