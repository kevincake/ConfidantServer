package com.springapp.mvc.SpringBean;

import com.springapp.mvc.model.ListManager;

/**
 * Created by glpublic on 2015/11/19.
 */
public class SpringLoaderBean {
    public void init(){
        ListManager.getInstance();
        System.out.print("=================");
    };
}
