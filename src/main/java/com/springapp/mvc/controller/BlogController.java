package com.springapp.mvc.controller;

import com.springapp.mvc.entities.BlogEntity;
import com.springapp.mvc.service.BlogService;
import com.springapp.mvc.service.RigsterService;
import com.springapp.mvc.util.Constants;
import com.springapp.mvc.util.PropertyUtil;
import com.springapp.mvc.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.management.ThreadInfo;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by glpublic on 2015/11/11.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
    @RequestMapping(value = "/deployBlog", method = RequestMethod.POST)
    public void deployBlog(HttpServletRequest request, HttpServletResponse response) {
        String account = request.getParameter(Constants.ACCOUNT_KEY);
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        BlogService service = new BlogService();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        ArrayList<String> photos = new ArrayList<String>();
        BlogEntity blog = new BlogEntity();
        for (int i = 1; i <= 9; i++) {
            String photoKey = "photo" + i;
            CommonsMultipartFile photo = (CommonsMultipartFile) multipartRequest
                    .getFile(photoKey);
            String urlPath = service.saveBlogPhoto(photo);
            if (photo != null) {
                if (i == 1) {
                    blog.setPhoto1(urlPath);
                } else if (i == 2) {
                    blog.setPhoto2(urlPath);
                } else if (i == 3) {
                    blog.setPhoto3(urlPath);
                } else if (i == 4) {
                    blog.setPhoto4(urlPath);
                } else if (i == 5) {
                    blog.setPhoto5(urlPath);
                } else if (i == 6) {
                    blog.setPhoto6(urlPath);
                } else if (i == 7) {
                    blog.setPhoto7(urlPath);
                } else if (i == 8) {
                    blog.setPhoto8(urlPath);
                } else if (i == 9) {
                    blog.setPhoto9(urlPath);
                }

            }
        }
        if (title==null||title.trim().equals("")){
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("blogTitleNullTips"));
            return;
        }
        if(content==null||content.trim().equals("")){
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("blogContentNullTips"));
            return;
        }
        if (account==null||account.equals("")){
            Util.writeErrorMsg2Client(response, PropertyUtil.getProperty("blogAccountNullTips"));
            return;
        }
        blog.setAccount(account);
        blog.setTime(System.currentTimeMillis() + "");
        blog.setMsgText(content);
        blog.setTitle(title);
        service.saveBlog(blog);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.获取到Images的文件夹路径，绝对.
        String rootPath = Util.getRootPath();
        String fullPath = rootPath + PropertyUtil.getProperty("headIconFolder");

    }

}
