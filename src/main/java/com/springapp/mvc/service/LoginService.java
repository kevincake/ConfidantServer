package com.springapp.mvc.service;

import com.springapp.mvc.dao.DBUtils;
import com.springapp.mvc.entities.UserEntity;
import com.springapp.mvc.util.Constants;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
        c.add(Restrictions.eq(Constants.ACCOUNT_KEY, account));//eq是等于，gt是大于，lt是小于,or是或
        c.add(Restrictions.eq("password",password));
        List<UserEntity> list = c.list();
        if (list==null||list.size()<=0){
            return null;
        }
        return list.get(Constants.SqlListDefaultIndex);
    }
    //更新用户最后一次登录的时间

    public static boolean isLogin(int userId){
        Session session = DBUtils.getSession();
        Criteria c = session.createCriteria(UserEntity.class);
        c.add(Restrictions.eq("userId", userId));//eq是等于，gt是大于，lt是小于,or是或
        List<UserEntity> list = c.list();
        if (list==null||list.size()<=0){
            return false;
        }
        UserEntity user = list.get(Constants.SqlListDefaultIndex);
        if (user==null){
            return false;
        }

        return false;
    }
}
