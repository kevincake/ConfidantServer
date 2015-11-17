package com.springapp.mvc.service;

import com.springapp.mvc.dao.DBUtils;
import com.springapp.mvc.entities.BlogEntity;
import com.springapp.mvc.entities.UserEntity;
import com.springapp.mvc.util.Util;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by glpublic on 2015/11/13.
 */
public class BlogService {
    //获取博客列表，分页
    public List<BlogEntity> getBlogList(int userId,int pageNum, int pageSize) {
        long time = System.currentTimeMillis();
        Session session = DBUtils.getSession();
        Criteria lastC = session.createCriteria(BlogEntity.class);
        lastC.add(Restrictions.eq("userId", userId));
        lastC.add(Restrictions.lt("time", time));
        lastC.setFirstResult((pageNum - 1) * pageSize);
        lastC.setMaxResults(pageSize);
        List<BlogEntity> blogList = lastC.list();
        return blogList;
    }
    //发布博客
    public BlogEntity saveBlog(BlogEntity blog) {
        Session session = DBUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(blog);
        transaction.commit();
        return blog;
    }
    public boolean deleteBlog(BlogEntity blog){
        Session session = DBUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(blog);
        transaction.commit();
        return true;
    }
    public String saveBlogPhoto(CommonsMultipartFile file) {
        String fileName = Util.savePhoto(file, Util.getBlogPath());
        String urlPath = Util.getBlogUrlPath(fileName);
        return urlPath;
    }

}
