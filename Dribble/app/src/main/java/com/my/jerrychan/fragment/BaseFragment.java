package com.my.jerrychan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.my.jerrychan.interf.GetDataCallBack;
import com.my.jerrychan.widgets.LoadDialog;

/**
 * Created by linchen on 16/2/24.
 * github:https://github.com/JerryChan123
 * e-mail:linchen0922@163.com
 */
public abstract class BaseFragment extends Fragment {
    protected GetDataCallBack getDataCallBack;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return getView(inflater,container,savedInstanceState);
    }


    public void setGetDataCallBack(GetDataCallBack callBack){
        getDataCallBack=callBack;
    }

    public abstract View getView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);
}
