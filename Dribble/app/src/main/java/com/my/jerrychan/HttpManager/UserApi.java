package com.my.jerrychan.httpManager;

import com.my.jerrychan.data.Author;
import com.my.jerrychan.data.Comment;
import com.my.jerrychan.data.FollowingPersonShot;
import com.my.jerrychan.data.Shots;
import com.my.jerrychan.data.User;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by linchen on 16/2/21.
 * github:https://github.com/JerryChan123
 * e-mail:linchen0922@163.com
 */
public class UserApi extends BaseApi{
    //自己的用户信息获取
    private interface UserImpl {
        @Headers({
                "Content-Type:application/json;charset=utf-8" ,
                "Server:nginx",
                "Cache-Control:max-age=0,private,must-revalidate",
                "Authorization:Bearer 030410453e69f1981606ddfa1be4caeb892a1ddd35457639d51a5e2d26110968"
        })
        @GET("{user}")
        Observable<User> getUsers(@Path("user") String user );


    }

    private static com.my.jerrychan.httpManager.UserApi.UserImpl userImpl=getRetrofit().create(UserImpl.class);

    public static Observable<User> getUser(String user){
        return userImpl.getUsers(user);
    }






    //shots列表获取
    private interface ShotsImpl {
        @Headers({
                "Content-Type:application/json;charset=utf-8" ,
                "Server:nginx",
                "Cache-Control:max-age=0,private,must-revalidate",
                "Authorization:Bearer 030410453e69f1981606ddfa1be4caeb892a1ddd35457639d51a5e2d26110968"
        })
        @GET("shots")

        Observable<List<Shots>> getShots(@Query("timeframe") String timeframe);
    }

    private static ShotsImpl shots= getRetrofit().create(ShotsImpl.class);

    public static  Observable<List<Shots>> getShots(String timeframe){
        return shots.getShots(timeframe);
    }


    //shots列表中的某一位的相关信息获取
    private interface AuthorImpl{
        @Headers({
                "Content-Type:application/json;charset=utf-8" ,
                "Server:nginx",
                "Cache-Control:max-age=0,private,must-revalidate",
                "Authorization:Bearer 030410453e69f1981606ddfa1be4caeb892a1ddd35457639d51a5e2d26110968"
        })
        @GET("shots/{id}")
        Observable<Author> getAuthorInfo(@Path("id") String id);
    }
    private static  AuthorImpl  author=getRetrofit().create(AuthorImpl.class);
    public static  Observable<Author> getAuthorInfo(String id){
        return author.getAuthorInfo(id);
    }


    //评论获取
    private interface  CommentImpl{
        @Headers({
                "Content-Type:application/json;charset=utf-8" ,
                "Server:nginx",
                "Cache-Control:max-age=0,private,must-revalidate",
                "Authorization:Bearer 030410453e69f1981606ddfa1be4caeb892a1ddd35457639d51a5e2d26110968"
        })
        @GET("shots/{id}/comments")
        Observable<List<Comment>> getAuthorComment(@Path("id") String id);
    }
    private static CommentImpl comment=getRetrofit().create(CommentImpl.class);
    public static Observable<List<Comment>> getAuthorComment(String id){
        return comment.getAuthorComment(id);
    }




    //评论获取
    private interface  FollowingImpl{
        @Headers({
                "Content-Type:application/json;charset=utf-8" ,
                "Server:nginx",
                "Cache-Control:max-age=0,private,must-revalidate",
                "Authorization:Bearer 030410453e69f1981606ddfa1be4caeb892a1ddd35457639d51a5e2d26110968"
        })
        @GET("user/following/shots")
        Observable<List<FollowingPersonShot>> getAuthorComment();
    }
    public static FollowingImpl following=getRetrofit().create(FollowingImpl.class);

    public static Observable<List<FollowingPersonShot>> getFollowingShots(){
        return following.getAuthorComment();
    }

}
