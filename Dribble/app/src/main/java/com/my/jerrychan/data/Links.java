package com.my.jerrychan.data;

/**
 * Created by linchen on 16/2/19.
 * github:https://github.com/JerryChan123
 * e-mail:linchen0922@163.com
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("web")
    @Expose
    private String web;

    /**
     *
     * @return
     * The web
     */
    public String getWeb() {
        return web;
    }

    /**
     *
     * @param web
     * The web
     */
    public void setWeb(String web) {
        this.web = web;
    }

}