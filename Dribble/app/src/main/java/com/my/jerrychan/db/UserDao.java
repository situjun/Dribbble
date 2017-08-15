package com.my.jerrychan.db;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.my.jerrychan.utils.DateUtils;
import com.my.jerrychan.data.User;

import java.sql.SQLException;

/**
 * Created by linchen on 16/2/20.
 * github:https://github.com/JerryChan123
 * e-mail:linchen0922@163.com
 */
public class UserDao {
    private Context context;
    private Dao<User, Integer> userDaoOpe;
    private DBhelper helper;

    public UserDao(Context context){
        this.context=context;
        helper=DBhelper.getInstance(context);
        try {
            userDaoOpe=helper.getDao(User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public   boolean updateRole(User role){
        boolean success=false;


        try {
            role.setUpdatedAt(DateUtils.changeToNormal(role.getUpdatedAt()));
            userDaoOpe.createOrUpdate(role);
            success=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
    public User getUser(){
        User role=null;

        try {
            int size=userDaoOpe.queryForAll().size();
            if (size!=0){
                role=userDaoOpe.queryForAll().get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  role;
    }
}
