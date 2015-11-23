package com.springapp.mvc.util;

import com.google.gson.Gson;
import com.springapp.mvc.dao.DBUtils;
import com.springapp.mvc.model.Base;
import com.springapp.mvc.model.ErrMsg;
import com.sun.deploy.net.HttpResponse;
import org.apache.commons.io.FileUtils;
import org.hibernate.Criteria;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by glpublic on 2015/11/4.
 */
public class Util {
    public static String ROOT = "ROOT";

    public static void writeObj2Clicent(HttpServletResponse response, Base obj) {
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

    public static void writeErrorMsg2Client(HttpServletResponse response, String errorMsg) {
        ErrMsg msg = new ErrMsg();
        msg.setResult(0);
        msg.setErrno(errorMsg);
        Util.writeObj2Clicent(response, msg);
    }

    public static String savePhoto(CommonsMultipartFile file, String path) {
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
        //返回用Url代表的图片

        return realFileName;
    }

    public static String getRootPath() {
        String filePath = "";

        URL url = Util.class.getResource("Util.class");
        String className = url.getFile();
        filePath = className.substring(0, className.indexOf(ROOT) + ROOT.length());
        System.out.print(filePath);
        return filePath;
    }

    public static String getHeadPath() {
        String rootPath = getRootPath();
        String headPath = rootPath + PropertyUtil.getProperty("headIconFolder");
        return headPath;
    }

    public static String getHeadUrlPath(String fileName) {
        String baseUrl = PropertyUtil.getProperty("baseUrl");
        String headIconFolder = PropertyUtil.getProperty("headIconFolder");
        String url = baseUrl + headIconFolder + fileName;
        return url;
    }

    public static String getBlogPath() {
        String rootPath = getRootPath();
        String headPath = rootPath + PropertyUtil.getProperty("blogPhotoPath");
        return headPath;
    }

    public static String getBlogUrlPath(String fileName) {
        String baseUrl = PropertyUtil.getProperty("baseUrl");
        String headIconFolder = PropertyUtil.getProperty("blogPhotoPath");
        String url = baseUrl + headIconFolder + fileName;
        return url;
    }

    public static String getStringFromJsonFile(String fileName) {
        String rootPath = getRootPath();
        String jsonPath = rootPath + PropertyUtil.getProperty("jsonFolderPath") + fileName;
        String contentString = "";
        try {
            contentString = FileUtils.readFileToString(new File(jsonPath), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentString;
    }

    public static boolean isCorrect(String param) {
        if (param == null || param.trim().equals("")) {
            return false;
        }
        return true;
    }

    ;

    public String decodeKey(String encryptString) {
        BASE64Decoder encode = new BASE64Decoder();
        return "";
    }

    ;

    // ==================================================
    // 加密body
    public static String getEncryptBody(String body, String key) {

        String encryptResult = YIHUOEncrypt(body, key);
        String base64Result = new BASE64Encoder().encode(body.getBytes());
        String numString = getNumString(base64Result);
        String enCodebody = "";
        try {
            enCodebody = new String(numString.getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return enCodebody;
    }

    // 數字字符串1_2_3
    public static String getNumString(String paramString) {
        String numString = "";
        String split = "_";
        for (int i = 0; i < paramString.length(); i++) {
            int num = (paramString.charAt(i));
            if (i == paramString.length() - 1) {
                numString = numString + num;
            } else {
                numString = numString + num + split;
            }

        }

        return numString;
    }

    // 抑或
    public static String YIHUOEncrypt(String body, String key) {
        String str1 = body;
        byte data[] = str1.getBytes();
        for (int i = 0; i < data.length; i++) {
            String str = key;
            byte ch = data[i];
            for (int j = 0; j < str.length(); j++) {
                ch = (byte) (ch ^ str.charAt(j));
            }
            data[i] = ch;
        }
        str1 = new String(data);
        return str1;
    }


}
