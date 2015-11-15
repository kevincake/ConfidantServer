package com.springapp.mvc.service;

import com.springapp.mvc.dao.DBUtils;
import com.springapp.mvc.entities.FriendEntity;
import com.springapp.mvc.entities.UserEntity;
import com.springapp.mvc.util.Constants;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by glpublic on 2015/11/5.
 */
public class FriendService {
//获取所有好友
    public List<FriendEntity> getFriends(int userId){
        Session session = DBUtils.getSession();
        Criteria c = session.createCriteria(FriendEntity.class);
        c.add(Restrictions.eq("userId", userId));//eq是等于，gt是大于，lt是小于,or是或
        List<FriendEntity> list = c.list();
       return list;
    }
    //添加好友
    public UserEntity addFriend(String account,String  friendAccount){
        FriendEntity friendentity = new FriendEntity();
        friendentity.setAccount(account);
        friendentity.setFriendAccount(friendAccount);
        friendentity.setIsBlack(0);
        friendentity.setIsProtect(0);
        Session session = DBUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(friendentity);
        transaction.commit();

         Criteria c = session.createCriteria(UserEntity.class);
        c.add(Restrictions.eq("userId", account));//eq是等于，gt是大于，lt是小于,or是或
        List<UserEntity> list = c.list();
        return list.get(0);
    }
    public boolean isFriendExist(int userId,int friendId){
        Session session = DBUtils.getSession();
        Criteria c = session.createCriteria(FriendEntity.class);
        c.add(Restrictions.eq("userId", userId));//eq是等于，gt是大于，lt是小于,or是或
        c.add(Restrictions.eq("friendId", friendId));
        List<FriendEntity> list = c.list();
        if (list!=null&&list.size()>0){return true;}
        return false;
    }
    //删除好友
    public boolean deleteFriend(int userId,int friendId){
        Session session = DBUtils.getSession();
        Criteria c = session.createCriteria(FriendEntity.class);
        c.add(Restrictions.eq("userId", userId));//eq是等于，gt是大于，lt是小于,or是或
        c.add(Restrictions.eq("friendId", friendId));
        List<FriendEntity> list = c.list();
        FriendEntity friendEntity = list.get(Constants.SqlListDefaultIndex);
        Transaction transaction = session.beginTransaction();
        session.delete(friendEntity);
        transaction.commit();
        return true;
    }
    public List<FriendEntity> getFriendListByPage(int pageIndex,int pageSize){
        Session session = DBUtils.getSession();
        Criteria c = session.createCriteria(FriendEntity.class);
        c.setFirstResult((pageIndex - 1) * pageSize);
        c.setMaxResults(Constants.SqlListPageSize);
        return  c.list();
    }
    public boolean blackFriend(int userId,int friendId){

        Session session = DBUtils.getSession();
        Criteria c = session.createCriteria(FriendEntity.class);
//        session.get()
        String hql = "UPDATE friend SET friend.isBlack=1 WHERE account="+userId+" and friendAccount="+friendId;
        Query updateQuery =  session.createSQLQuery(hql);
        updateQuery.executeUpdate();
        return true;
    };
}
