package zj.bannerdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * 加载本地图片
         */
        findViewById(R.id.b1local).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,BaseLocalDemo.class));
            }
        });


        /**
         * 调整子item间隙
         */
        findViewById(R.id.b3itemdebug).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ItemMarginDemo.class));
            }
        });


        /**
         * 加载网络图片
         */
        findViewById(R.id.b2net).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,BaseNetDemo.class));
            }
        });

        /**
         * WITHPHOTOVIEW
         */
        findViewById(R.id.b4withphoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,WithPhotoDemo.class));
            }
        });

    }
}
