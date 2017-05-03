package com.wzq.jiyun;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 2017/4/24.
 */

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<String> mList;
    private View view;

    //自定义接口
    public interface MyItemClickListener {
        //自定义抽象方法，参数    为View和位置（索引）
        void onItemClick(View v, int postion);
    }

    //全局变量，自定义接口
    private MyItemClickListener myItemClickListener;

    //自定义方法，类似点击监听的方法
    public void SetOnItemClickListener(MyItemClickListener myItemClickListener) {
        this.myItemClickListener = myItemClickListener;
    }

    public MyAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.itemview, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyHolder myHolder = (MyHolder) holder;
        myHolder.textView.setText(mList.get(position));
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myItemClickListener.onItemClick(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    //内部类MyHolder继承ViewHolder,并且实现OnClickListener接口
    class MyHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public MyHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_title);
        }
    }



}
