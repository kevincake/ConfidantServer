package com.springapp.mvc.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.springapp.mvc.util.Util;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by glpublic on 2015/11/19.
 */
public class ListManager {
    private ListManager() {
//        Gson gson = new Gson();
        final GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson gson = gsonBuilder.create();
        rechargeTable = gson.fromJson(Util.getStringFromJsonFile("recharge.json"), Recharge[].class);
        giftTable =  gson.fromJson(Util.getStringFromJsonFile("gift.json"), Gift[].class);
    }


    Recharge[] rechargeTable;
    Gift[] giftTable;
    public static ListManager manager;

    public static ListManager getInstance() {
        if (manager == null) {
            manager = new ListManager();
        }
        return manager;
    }


}
