package com.my.jerrychan.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.my.jerrychan.widgets.LoadDialog;

/**
 * Created by linchen on 16/2/20.
 * github:https://github.com/JerryChan123
 * e-mail:linchen0922@163.com
 */
public class BaseActivity extends AppCompatActivity {
    protected LoadDialog loadDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setApiConnection();

        onChildCreate(savedInstanceState);

        onEndChildCreate(savedInstanceState);

    }

    protected void onEndChildCreate(@Nullable Bundle savedInstanceState){
        loadDialog=new LoadDialog(this);
    }
    protected void onChildCreate(@Nullable Bundle savedInstanceState) {

    }

    //    protected void setApiConnection(){
//        retrofit= BaseApi.
//    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
           return true;
        }
        return super.onKeyDown(keyCode, event);
    }



}
