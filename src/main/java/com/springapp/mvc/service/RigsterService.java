package com.springapp.mvc.service;

import com.springapp.mvc.dao.DBUtils;
import com.springapp.mvc.entities.UserEntity;
import com.springapp.mvc.model.User;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
        c.add(Restrictions.eq("userName",userName));//eq是等于，gt是大于，lt是小于,or是或
        List<UserEntity> list = c.list();
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    ;
    public boolean saveUser(UserEntity user){
        Session session = DBUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        return true;
    }
    public boolean saveHeadIcon(String fileContent) {
        return false;
    }

    ;
}
// 将base64 转 字节数组
//Base64 base = new Base64();
//        byte[] decode = base.decode(image);
//        // 图片输出路径
//        String imagePath = commodityFilePath + "/" + System.currentTimeMillis() + ".png";
//        // 定义图片输入流
//        InputStream fin = new ByteArrayInputStream(decode);
//        // 定义图片输出流
//        FileOutputStream fout= null;
//        try {
//        fout = new FileOutputStream(imagePath);
//        } catch (FileNotFoundException e1) {
//        e1.printStackTrace();
//        }
//        // 写文件
//        byte[] b=new byte[1024];
//        int length=0;
//        try {
//        while((length=fin.read(b))>0){
//
//        fout.write(b, 0, length);
//        }
//        // 关闭数据流
//        fin.close();
//        fout.close();
//        } catch (IOException e1) {
//        e1.printStackTrace();
//        }
//
//
//
//        }catch(Exception e){
//
//        e.printStackTrace();
//        }
//        return true;
//        };

//}
