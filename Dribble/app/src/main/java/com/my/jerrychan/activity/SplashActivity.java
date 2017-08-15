package com.my.jerrychan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.my.jerrychan.httpManager.UserApi;
import com.my.jerrychan.utils.DateUtils;
import com.my.jerrychan.R;
import com.my.jerrychan.data.User;
import com.my.jerrychan.db.UserDao;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SplashActivity extends BaseActivity {
    private final int RESULT = 10001;
    private final static String TAG = SplashActivity.class.getSimpleName() + ":";
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == RESULT) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            } else {
                super.handleMessage(msg);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getData();
    }


    private void getData() {
        UserApi.getUser("user")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<User>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("aqqqqqq",e.getMessage());
                    }

                    @Override
                    public void onNext(User user) {
                        Log.e(TAG + "success", user.toString());
                        setInDb(user);

                    }
//

                });
    }

    private void setInDb(final User result) {

        MyThread thread = new MyThread(result);
        thread.start();
    }

    private class MyThread extends Thread {
        User result;

        public MyThread(User result) {
            this.result = result;
        }

        @Override
        public void run() {
            UserDao dao = new UserDao(SplashActivity.this);
            User user = dao.getUser();
            boolean updateSuccess = false;
            if (user == null) {
                updateSuccess = dao.updateRole(result);
            } else {
                String historyTime = dao.getUser().getUpdatedAt();
                String currentTime = result.getUpdatedAt();
                if (DateUtils.compareTwoTime(historyTime, currentTime)) {
                    updateSuccess = dao.updateRole(result);
                } else {
                    updateSuccess = true;
                }
            }

            if (updateSuccess) {
                Message message = handler.obtainMessage();
                message.what = RESULT;
                message.sendToTarget();
            } else {
                Toast.makeText(SplashActivity.this, "数据库个人信息更新出错", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}

