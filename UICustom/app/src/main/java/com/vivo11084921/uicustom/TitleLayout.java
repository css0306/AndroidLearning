package com.vivo11084921.uicustom;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, AttributeSet attrs){ // 重写构造函数
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);// from方法构建一个LayoutInflater对象，
        // inflate()方法可以动态加载一个布局文件。第一个参数：要加载的布局文件的id；
        // 第二个参数：给加载好的布局再添一个父布局，这里即TitleLayout.
        Button titleBack = (Button) findViewById(R.id.title_back);
        Button titleEdit = (Button) findViewById(R.id.title_edit);
        titleBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ((Activity) getContext()).finish();
            }
        });
        titleEdit.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getContext(), "You clicked Edit button", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
