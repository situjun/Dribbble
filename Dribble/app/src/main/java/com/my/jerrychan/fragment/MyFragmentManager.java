package com.my.jerrychan.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.my.jerrychan.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linchen on 16/2/24.
 * github:https://github.com/JerryChan123
 * e-mail:linchen0922@163.com
 */
public class MyFragmentManager {
    private FragmentManager fragmentManager;
    private List<BaseFragment>  fragmentList;
    private ShotsFragment shotsFragment;
    private FollowingFragment followingFragment;

    public MyFragmentManager(FragmentActivity activity){
        fragmentManager=activity.getSupportFragmentManager();

        buidUpFragment();
    }

    private void buidUpFragment(){
        fragmentList=new ArrayList<>();
        shotsFragment=new ShotsFragment();
        fragmentList.add(shotsFragment);
        followingFragment=new FollowingFragment();
        fragmentList.add(followingFragment);

        FragmentTransaction transaction=fragmentManager.beginTransaction();
        for (Fragment fragment:fragmentList){
            transaction.add(R.id.frag_father,fragment);
        }
        transaction.commit();

    }
    public BaseFragment getFragmentAt(int position){
        return fragmentList.get(position);
    }

    public void hideAll(){
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        for(Fragment fragment:fragmentList){
            transaction.hide(fragment);
        }
        transaction.commit();
    }

    public void showFragment(int position){
        hideAll();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.show(fragmentList.get(position)).commit();
    }

    public  int getFragmentsSize(){
        return fragmentList.size();
    }

}
