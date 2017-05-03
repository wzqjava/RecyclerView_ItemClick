package com.wzq.jiyun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<String>();
        for (int i = 0; i < 500; i++) {
            list.add("---" + i);
        }

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        MyAdapter mAdapter = new MyAdapter(this, list);
        recyclerView.setAdapter(mAdapter);

        mAdapter.SetOnItemClickListener(new MyAdapter.MyItemClickListener() {

            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(MainActivity.this, "我是回调--->"+position, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
