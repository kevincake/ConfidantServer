package com.springapp.mvc.util;

import com.google.gson.Gson;
import com.springapp.mvc.dao.DBUtils;
import com.springapp.mvc.model.Base;
import com.springapp.mvc.model.ErrMsg;
import com.sun.deploy.net.HttpResponse;
import org.hibernate.Criteria;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by glpublic on 2015/11/4.
 */
public class Util {
    public static void writeObj2Clicent(HttpServletResponse response,Base obj)  {
        Gson gson = new Gson();
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        String data = gson.toJson(obj);
        try {
            response.getWriter().write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeErrorMsg2Client(HttpServletResponse response,String errorMsg){
        ErrMsg msg = new ErrMsg();
        msg.setResult(0);
        msg.setErrno(errorMsg);
        Util.writeObj2Clicent(response, msg);
    }
   public static String savePhoto(CommonsMultipartFile file,String path){
       // 获得文件名：
       String realFileName = System.currentTimeMillis() + "";
       System.out.println("获得文件名：" + realFileName);

       // 创建文件
       File dirPath = new File(path);
       if (!dirPath.exists()) {
           dirPath.mkdir();
       }
       String finalPath = path + realFileName;
       File uploadFile = new File(finalPath);
       try {
           FileCopyUtils.copy(file.getBytes(), uploadFile);
       } catch (IOException e) {
           e.printStackTrace();
       }
       return finalPath;
   }


}
