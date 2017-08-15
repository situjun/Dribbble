package com.my.jerrychan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.my.jerrychan.R;
import com.my.jerrychan.activity.AuthorShotsActivity;
import com.my.jerrychan.data.Shots;
import com.my.jerrychan.httpManager.UserApi;
import com.my.jerrychan.utils.ShotsRecycleAdapter;
import com.my.jerrychan.widgets.LoadDialog;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by linchen on 16/2/24.
 * github:https://github.com/JerryChan123
 * e-mail:linchen0922@163.com
 */
public class ShotsFragment extends BaseFragment {
    private View rootView ;
    private RecyclerView recyclerView;
    private List<Shots> shotses;
    private ShotsRecycleAdapter shotsRecycleAdapter;


    @Override
    public View getView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.content_main,container,false);

        init();
        return rootView;
    }

    private void init() {
        recyclerView= (RecyclerView) rootView.findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        shotses=new ArrayList<>();
        setMainData();
    }
    private  void setMainData(){
        UserApi.getShots("year")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Shots>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Shots> shotses) {
                        initViewData(shotses);
                    }
                });
    }
    private void initViewData(final List<Shots> shotses){
        this.shotses=shotses;
        shotsRecycleAdapter=new ShotsRecycleAdapter(getActivity(),this.shotses);
        shotsRecycleAdapter.setOnRecylceItemClick(new ShotsRecycleAdapter.RecycleItemClickListsener() {
            @Override
            public void onClick(View view,int position) {
                Intent intent=new Intent(getActivity(), AuthorShotsActivity.class);
                intent.putExtra("shotsId",shotses.get(position).getId());
                intent.putExtra("authorTitle",shotses.get(position).getTitle());
                startActivity(intent);

            }
        });

        recyclerView.setAdapter(shotsRecycleAdapter);
        getDataCallBack.getDataIsOk();
    }
}
