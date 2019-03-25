package com.vivo11084921.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

//    private static final String TAG = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity",this.toString()); // 测试启动模式
        setContentView(R.layout.activity_first);  //调用setContentView方法，给当前活动引入了一个activity_first布局
//        Log.d("FirstActivity", "onCreate execute");

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast用法
                //Toast.makeText(FirstActivity.this, "You clicked Button1",
                //        Toast.LENGTH_SHORT).show();

                // finish()销毁当前Activity
                // finish();

                // 显示Intent
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //startActivity(intent);

                // 隐式Intent
                //Intent intent = new Intent("com.vivo11084921.api.lifecycle.ACTION_START");
                //intent.addCategory("com.vivo11084921.api.lifecycle.MY_CATEGORY");
                //startActivity(intent);

                // 通过隐式Intent启动系统浏览器
                //Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("http://www.baidu.com"));
                //startActivity(intent);

                // 在程序中调用拨号界面
                //Intent intent = new Intent(Intent.ACTION_DIAL);
                //intent.setData(Uri.parse("tel:10086"));
                //startActivity(intent);

                // 向下一个活动传递数据
                //String data = "Hello Second Activity.";
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class); // 显式
                //intent.putExtra("extra_data", data);
                //startActivity(intent);

                // 返回数据给上一个活动
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //startActivityForResult(intent,1);

                // 测试启动模式
                Intent intent = new Intent(FirstActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch (requestCode){
            case 1:
                if(requestCode == RESULT_OK){
                    String returnData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnData);
                }
                break;
            default:
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}
