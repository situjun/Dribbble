package com.my.jerrychan.widgets;

import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.support.v7.app.AlertDialog;

import com.my.jerrychan.R;

/**
 * Created by linchen on 16/2/23.
 * github:https://github.com/JerryChan123
 * e-mail:linchen0922@163.com
 */
public class TipsDialog extends AlertDialog {
    private AlertDialog.Builder builder;
    public TipsDialog(Context context) {
        super(context);
        builder=new Builder(context);
    }

//    protected TipsDialog(Context context, int theme) {
//        super(context, theme);
//    }


    public void showDialog(){
        if (builder!=null){
            builder.show();
        }
    }

    public AlertDialog.Builder setDialogCancelListener(CharSequence text,DialogInterface.OnClickListener listener){
        builder.setNegativeButton(text,listener);
        return builder;
    }

    public AlertDialog.Builder setDialogSureListener(CharSequence text,DialogInterface.OnClickListener listener)
    {
        builder.setPositiveButton(text,listener);
        return builder;
    }

    public AlertDialog.Builder setTitle(String title){
        builder.setTitle(title);
        return builder;
    }


    public AlertDialog.Builder setContentText(String text){
        builder.setMessage(text);
        return builder;
    }

    public AlertDialog.Builder buildEnd(){
        builder.create();
        return builder;
    }


}
