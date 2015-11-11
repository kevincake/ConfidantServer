package com.springapp.mvc.service;

import com.springapp.mvc.dao.DBUtils;
import com.springapp.mvc.entities.ChatEntity;
import com.springapp.mvc.entities.UserEntity;
import com.springapp.mvc.util.Constants;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by glpublic on 2015/11/11.
 */
public class ChatService {
    public static ChatEntity updateChat(ChatEntity chat){
        Session session = DBUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(chat);
        transaction.commit();
        return chat;
    }
    public static ChatEntity getChatByUserId(int userId){
        Session session = DBUtils.getSession();
        Criteria c = session.createCriteria(ChatEntity.class);
        c.add(Restrictions.eq("userId", userId));//eq是等于，gt是大于，lt是小于,or是或
        List<ChatEntity> list = c.list();
        if (list==null||list.size()<=0){
            return null;
        }
        return list.get(Constants.SqlListDefaultIndex);
    }

}
