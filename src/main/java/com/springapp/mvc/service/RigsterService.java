package com.springapp.mvc.service;

import com.springapp.mvc.dao.DBUtils;
import com.springapp.mvc.entities.UserEntity;
import com.springapp.mvc.util.PropertyUtil;
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

        String name = multipartRequest.getParameter("hello");
        System.out.println("name: " + name);
        // 获得文件名：
        String realFileName = System.currentTimeMillis() + "";
        System.out.println("获得文件名：" + realFileName);
        // 获取路径
        String ctxPath = request.getSession().getServletContext().getRealPath(
                "/")
                + "images/";
        // 创建文件
        File dirPath = new File(ctxPath);
        if (!dirPath.exists()) {
            dirPath.mkdir();
        }
        String finalPath = ctxPath + realFileName;
        File uploadFile = new File(finalPath);
        try {
            FileCopyUtils.copy(file.getBytes(), uploadFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return finalPath;
    }


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
