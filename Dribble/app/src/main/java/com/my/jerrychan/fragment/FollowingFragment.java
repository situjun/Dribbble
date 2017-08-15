package com.my.jerrychan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.my.jerrychan.R;
import com.my.jerrychan.activity.AuthorShotsActivity;
import com.my.jerrychan.data.FollowingPersonShot;
import com.my.jerrychan.httpManager.UserApi;
import com.my.jerrychan.utils.FollowingAdapter;

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
public class FollowingFragment extends BaseFragment {
    private final static String TAG=FollowingFragment.class.getSimpleName();
    private View rootView ;
    private RecyclerView recyclerView;
    private List<FollowingPersonShot> shotses;
    private FollowingAdapter followingAdapter;
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
        setData();
    }

    private void setData() {
        UserApi.getFollowingShots()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<FollowingPersonShot>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<FollowingPersonShot> followingPersonShots) {
                        Log.e(TAG,"data get"+followingPersonShots.toString());
                       initData(followingPersonShots);
                    }
                });

    }

    private void initData(List<FollowingPersonShot> followingPersonShots) {
        shotses.addAll(followingPersonShots);
        followingAdapter =new FollowingAdapter(getActivity());
        followingAdapter.addData(shotses);
        followingAdapter.setOnRecylceItemClick(new FollowingAdapter.RecycleItemClickListsener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent=new Intent(getActivity(), AuthorShotsActivity.class);
                intent.putExtra("shotsId",shotses.get(position).getId());
                intent.putExtra("authorTitle",shotses.get(position).getTitle());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(followingAdapter);
        getDataCallBack.getDataIsOk();

    }
}
