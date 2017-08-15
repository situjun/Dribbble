package com.my.jerrychan.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.my.jerrychan.R;
import com.my.jerrychan.data.Author;
import com.my.jerrychan.data.Comment;
import com.my.jerrychan.widgets.CircleImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by linchen on 16/2/21.
 * github:https://github.com/JerryChan123
 * e-mail:linchen0922@163.com
 */
public class AuthorShotRecycleAdapter extends RecyclerView.Adapter<AuthorShotRecycleAdapter.MyViewHolder> {

    private Context context;
    private List<Comment> mDatas;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_NORMAL = 1;
    private Author author;


    private View mHeaderView;

    public AuthorShotRecycleAdapter(Context context,List<Comment> mDatas){
        this.context=context;
        this.mDatas=mDatas;

    }


    public void setHeaderView(View headerView, Author author) {
        mHeaderView = headerView;
        notifyItemInserted(0);
//        notifyDataSetChanged();
        setHeaderInfo(author);

    }
    private void setHeaderInfo(Author author){
        this.author=author;
    }






    public void addDatas(List<Comment> datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    @Override
    public int getItemViewType(int position) {
        if(mHeaderView == null) return TYPE_NORMAL;
        if(position == 0) return TYPE_HEADER;
        return TYPE_NORMAL;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder;
        if (mHeaderView!=null&&viewType==TYPE_HEADER){
            viewHolder=new MyViewHolder(mHeaderView);

        }else {
            viewHolder = new MyViewHolder(LayoutInflater.from(
                    context).inflate(R.layout.item_home, parent,
                    false));
        }

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if(getItemViewType(position) == TYPE_HEADER){
           holder.tv_authorname.setText(author.getUser().getUsername());
            holder.tv_author_date.setText(DateUtils.changeToNormal(author.getUpdatedAt()));
            Picasso.with(context).load(author.getUser().getAvatarUrl()).into(holder.iv_author_img);
            if (author.getDescription()==null){
                holder.tv_author_description.setText("no description about the author");
            }else {
                holder.tv_author_description.setText(Html.fromHtml(author.getDescription()));
            }
        }else {
            int realPostion=getRealPosition(holder);
            holder.tv_comment_author_update.setText(DateUtils.changeToNormal(mDatas.get(realPostion).getUpdatedAt()));
            holder.tv_comment_authorname.setText(mDatas.get(realPostion).getUser().getUsername());
            holder.tv_comment_authorcomment.setText(Html.fromHtml(mDatas.get(realPostion).getBody()));
            Picasso.with(context).load(mDatas.get(realPostion).getUser().getAvatarUrl()).into(holder.iv_comment_author_img);
        }


    }

    @Override
    public int getItemCount() {
        return  mHeaderView == null ? mDatas.size() : mDatas.size() + 1;
    }
    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv_comment_authorname,tv_comment_authorcomment,tv_comment_author_update;
        CircleImageView iv_comment_author_img;
        //头部
        TextView tv_authorname,tv_author_date,tv_author_description;
        CircleImageView iv_author_img;

        public MyViewHolder(View view)
        {
            super(view);
            if(itemView == mHeaderView) {
                tv_author_description= (TextView) itemView.findViewById(R.id.tv_author_description);
                tv_author_date= (TextView) itemView.findViewById(R.id.tv_author_date);
                tv_authorname= (TextView) itemView.findViewById(R.id.tv_authorname);
                iv_author_img= (CircleImageView) itemView.findViewById(R.id.author_img);

            }else {
                tv_comment_author_update= (TextView) itemView.findViewById(R.id.tv_comment_person_update);
                tv_comment_authorcomment= (TextView) itemView.findViewById(R.id.tv_comment_person_comment);
                tv_comment_authorname= (TextView) itemView.findViewById(R.id.tv_comment_person_name);
                iv_comment_author_img= (CircleImageView) itemView.findViewById(R.id.iv_comment_person_img);
            }

        }
    }
}
