package com.springapp.mvc.service;

import com.springapp.mvc.dao.DBUtils;
import com.springapp.mvc.entities.UserEntity;
import com.springapp.mvc.util.PropertyUtil;
import com.springapp.mvc.util.Util;
import org.apache.commons.codec.binary.Base64;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by glpublic on 2015/11/3.
 */
public class RigsterService {
    public static boolean checkMobile(String mobile) {
        String regex = "(\\+\\d+)?1[3458]\\d{9}$";
        return Pattern.matches(regex, mobile);
    }

    //是否包含 . 号
    public static boolean checkContainsDot(String username) {
        return username.contains(".");
    }

    //是否包含连词符
    public static boolean checkContainsHyphen(String username) {
        return username.contains("-");
    }

    //密码长度 6-20
    public static boolean checkUserPasswordLength(String pwd) {
        return pwd.length() > 5 && pwd.length() < 21;
    }

    //用户名是否存在
    public boolean isUserNameExist(String userName) {
        Session session = DBUtils.getSession();
        Criteria c = session.createCriteria(UserEntity.class);
        c.add(Restrictions.eq("userName", userName));//eq是等于，gt是大于，lt是小于,or是或
        List<UserEntity> list = c.list();
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean isAccountExist(String account) {
        Session session = DBUtils.getSession();
        Criteria c = session.createCriteria(UserEntity.class);
        c.add(Restrictions.eq("account", account));//eq是等于，gt是大于，lt是小于,or是或
        List<UserEntity> list = c.list();
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    ;

    public boolean saveUser(UserEntity user) {
        Session session = DBUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        return true;
    }

    public String saveHeadIcon(HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest
                .getFile("fileUpload");
        String fileName = Util.savePhoto(file, Util.getHeadPath());
        String urlPath = Util.getHeadUrlPath(fileName);
        return urlPath;
    }
}
