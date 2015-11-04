package com.springapp.mvc.util;

import com.google.gson.Gson;
import com.springapp.mvc.model.Base;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
}
