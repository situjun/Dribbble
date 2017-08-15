package com.my.jerrychan.widgets;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.my.jerrychan.R;
import com.my.jerrychan.widgets.loadingView.spinnerloading.SpinnerLoading;

/**
 * Created by linchen on 16/2/22.
 * github:https://github.com/JerryChan123
 * e-mail:linchen0922@163.com
 */
public class LoadDialog {
    private Context context;
    private Dialog mDialog;
    private SpinnerLoading mLoadingView;
    private View mDialogContentView;
    private TextView tv_loadingtext;

    public LoadDialog(Context context){
        this.context=context;
        init();
    }

    private void init() {
        mDialog=new Dialog(context, R.style.custom_dialog);
        mDialogContentView= LayoutInflater.from(context).inflate(R.layout.dialog_loadingview,null);
        mLoadingView= (SpinnerLoading) mDialogContentView.findViewById(R.id.loading_view);
        mLoadingView.setPaintMode(1);
        mLoadingView.setCircleRadius(30);
        mLoadingView.setItemCount(6);

        mDialog.setContentView(mDialogContentView);
    }



//    public void setLoadingText(String str){
//        tv_loadingtext.setText(str);
//    }

    public void showDialog(){

        mDialog.show();
        mDialog.setCanceledOnTouchOutside(false);
    }
    public void dismissDialog(){
        if (mDialog.isShowing()){
            mDialog.dismiss();
        }
    }
    public boolean isShowing(){
        return mDialog.isShowing();
    }
}
