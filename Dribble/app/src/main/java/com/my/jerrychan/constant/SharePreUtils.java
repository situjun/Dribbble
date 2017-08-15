package com.my.jerrychan.constant;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by linchen on 16/2/20.
 * github:https://github.com/JerryChan123
 * e-mail:linchen0922@163.com
 */
public class SharePreUtils {

    public static  void setUserTimeUpdate(Context context,String time){
        SharedPreferences sharedPreferences=context.getSharedPreferences("time_user",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("time",time);
        editor.commit();
    }

    public static String getUserTimeUpdate(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences("time_user",Context.MODE_PRIVATE);
        return sharedPreferences.getString("time","");
    }
}
