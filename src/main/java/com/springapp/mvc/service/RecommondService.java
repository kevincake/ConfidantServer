package com.springapp.mvc.service;

import com.springapp.mvc.dao.DBUtils;
import com.springapp.mvc.entities.FriendEntity;
import com.springapp.mvc.entities.UserEntity;
import com.springapp.mvc.util.Constants;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Random;

/**
 * Created by glpublic on 2015/11/9.
 */
public class RecommondService {
    //获取建议列表，分页
    public List<UserEntity> getRecommondList(long time, int pageNum, int pageSize) {
        Session session = DBUtils.getSession();
        Criteria c = session.createCriteria(UserEntity.class);
        Criteria lastC = session.createCriteria(UserEntity.class);
        lastC.setFirstResult((pageNum - 1) * pageSize);
        lastC.setMaxResults(pageSize);
        List<UserEntity> recommondList = lastC.list();
        return recommondList;
    }

    //获取所有好友
    public List<UserEntity> getRecommondListBySearch(float latitude, float longtitude, int sex, int pageNum, int pageSize) { //--
        Session session = DBUtils.getSession();
        Criteria c = session.createCriteria(UserEntity.class);
        c.add(Restrictions.ne(Constants.LATITUDE, latitude));
        c.add(Restrictions.ne(Constants.LONGITUDE, longtitude + ""));
        c.add(Restrictions.eq(Constants.SEX, sex));

        c.setFirstResult((pageNum - 1) * pageSize);
        c.setMaxResults(pageSize);
        return c.list();
    }

    //获取推荐文本聊天对象
    public UserEntity getRecommondTUser(int userId, int chatType) {

        if (!LoginService.isLogin(userId)) {
            return null;
        }
        Session session = DBUtils.getSession();
        Criteria c = session.createCriteria(UserEntity.class);
        c.add(Restrictions.ne("userId", userId));
        c.add(Restrictions.ne("chatType", chatType));
        List<UserEntity> recommondList = c.list();
        //随机取一个不重复的userIndex
        UserEntity user = null;
        for (int i = 0; i < 10; i++) {
            int userIndex = new Random(recommondList.size()).nextInt();
            user = recommondList.get(userIndex);
            if (user == null) {
                continue;
            } else {
                return user;
            }
        }
        return user;
    }

    ;
}
