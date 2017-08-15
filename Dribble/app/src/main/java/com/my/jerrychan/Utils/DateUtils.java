package com.my.jerrychan.utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by linchen on 16/2/20.
 * github:https://github.com/JerryChan123
 * e-mail:linchen0922@163.com
 */
public class DateUtils {
    private  static  final String TAG="DateUtils ";
//    public static String changeTime(String timeStr){
//        Date d;
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z");//注意格式化的表达式
//        try {
//             d = format.parse(timeStr);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        return d.before()
//    }

    /**
     * 比较两个时间的大小
     * @param history 历史版本时间
     * @param currrent 当前时间
     * @return
     */
    public static boolean compareTwoTime(String history,String currrent){
        Date hisDate=null,currentDate=null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            currentDate=format.parse(changeToNormal(currrent));
            hisDate=format.parse(history);

        } catch (ParseException e) {
            Log.e(TAG,"comapreTwoTime is wrong ,please check!");
            e.printStackTrace();

        }
        return currentDate.after(hisDate);
    }

    public static  String  changeToNormal(String timeStr){
        return  timeStr.replace("T"," ").replace("Z","");
    }
}
