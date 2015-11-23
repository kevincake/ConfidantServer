package com.springapp.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by glpublic on 2015/11/10.
 */
@Controller
@RequestMapping("/gift")
/**
 * Created by glpublic on 2015/11/10.
 */


public class RechargeController {
    @RequestMapping(value = "/doRecharge", method = RequestMethod.GET)
    public void doRecharge(HttpServletResponse response, HttpServletRequest request) {
        String key = request.getParameter("key");
        String[] splitArr = key.split("_");
        String signerStr = "";
        for (int i=0;i<splitArr.length;i++){
            signerStr = signerStr+splitArr[i];
        }
//        return signerStr;



    }
}
