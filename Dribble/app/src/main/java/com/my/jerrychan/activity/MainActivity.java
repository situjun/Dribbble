package com.my.jerrychan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.my.jerrychan.fragment.BaseFragment;
import com.my.jerrychan.fragment.MyFragmentManager;
import com.my.jerrychan.fragment.ShotsFragment;
import com.my.jerrychan.httpManager.UserApi;
import com.my.jerrychan.R;
import com.my.jerrychan.interf.GetDataCallBack;
import com.my.jerrychan.utils.ShotsRecycleAdapter;
import com.my.jerrychan.data.Shots;
import com.my.jerrychan.data.User;
import com.my.jerrychan.db.UserDao;
import com.my.jerrychan.widgets.CircleImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, GetDataCallBack {
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private final static String TAG = "MainActivity";
    private CircleImageView iv_user_img;
    private TextView tv_username, tv_userinfo;
    private MyFragmentManager myFragmentManager;
    private CompositeSubscription compositeSubscription;
    //    private List<Shots> shotses;
//    private RecyclerView recyclerView;
//    private ShotsRecycleAdapter shotsRecycleAdapter;
    private FrameLayout fl_father;

    @Override
    protected void onChildCreate(@Nullable Bundle savedInstanceState) {
        super.onChildCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Shots");
        setSupportActionBar(toolbar);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //NavigationView的子View必须这样子获取，不然回报空指针错误，findViewById找不到对应id
        View view = navigationView.getHeaderView(0);
        tv_userinfo = (TextView) view.
                findViewById(R.id.textview_userinfo);
        iv_user_img = (CircleImageView) view.
                findViewById(R.id.user_img);
        tv_username = (TextView) view.
                findViewById(R.id.textview_username);

//        recyclerView= (RecyclerView) findViewById(R.id.rv_list);
        fl_father = (FrameLayout) findViewById(R.id.frag_father);


        setDrawerData();
//        setMainData();
    }

    @Override
    protected void onEndChildCreate(@Nullable Bundle savedInstanceState) {
        super.onEndChildCreate(savedInstanceState);
        loadDialog.showDialog();
       setFragment();
    }

    private void setFragment() {
        myFragmentManager = new MyFragmentManager(this);
        myFragmentManager.showFragment(0);
        for (int i=0;i<myFragmentManager.getFragmentsSize();i++){
            myFragmentManager.getFragmentAt(i).setGetDataCallBack(this);
        }
    }

    //获取抽屉个人信息数据
    private void setDrawerData() {
        Subscriber<User> subscriber = new Subscriber<User>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                if (e.getMessage() != null) {
                    Log.e(TAG, "rx Java on error: " + e.getMessage());
                } else {
                    Log.e(TAG, "rx Java on error: Message is null ");

                }
            }

            @Override
            public void onNext(User user) {
                tv_userinfo.setText(user.getHtmlUrl());
                tv_username.setText(user.getUsername());
                Picasso.with(MainActivity.this).load(user.getAvatarUrl()).into(iv_user_img);
            }
        };
        Observable.create(new Observable.OnSubscribe<User>() {
            @Override
            public void call(Subscriber<? super User> subscriber) {
                UserDao userDao = new UserDao(MainActivity.this);
                subscriber.onNext(userDao.getUser());
                subscriber.onCompleted();
            }
        })
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(subscriber);
        compositeSubscription = new CompositeSubscription();
        compositeSubscription.add(subscriber);

    }

    @Override
    protected void onDestroy() {
        //防止内存泄露问题
        if (!compositeSubscription.isUnsubscribed()) {
            compositeSubscription.unsubscribe();
        }
        super.onDestroy();
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_shots) {
            myFragmentManager.showFragment(0);
            toolbar.setTitle("Shots");

        } else if (id == R.id.nav_following) {
            myFragmentManager.showFragment(1);
            toolbar.setTitle("Following");

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public void getDataIsOk() {
        if (loadDialog.isShowing())
            loadDialog.dismissDialog();
    }
}
