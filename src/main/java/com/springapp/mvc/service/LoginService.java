package com.springapp.mvc.service;

import com.springapp.mvc.dao.DBUtils;
import com.springapp.mvc.entities.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by glpublic on 2015/11/5.
 */
public class LoginService {
    //用户名是否存在
    public UserEntity getUser(String account,String password) {
        Session session = DBUtils.getSession();
        Criteria c = session.createCriteria(UserEntity.class);
        c.add(Restrictions.eq("account", account));//eq是等于，gt是大于，lt是小于,or是或
        c.add(Restrictions.eq("password",password));
        List<UserEntity> list = c.list();
        if (list==null){
            return null;
        }
        return list.get(1);
    }
}
