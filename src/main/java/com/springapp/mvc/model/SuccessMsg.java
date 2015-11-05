package com.springapp.mvc.model;

/**
 * Created by glpublic on 2015/11/5.
 */
public class SuccessMsg extends Base{
   public static String getSuccessFormat(String data){
        return "{\"result\":1,\"data\":"+data+"}";
    }
}
