package com.example.caoyang.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.skateboard.zxinglib.CaptureActivity;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        Button startBtn = findViewById(R.id.button);
        SwipeMenuView swipeMenuView =  findViewById(R.id.swipeMenuView);
        swipeMenuView.setIos(false);
        swipeMenuView.setUpDownSwipeIntercept(false);
//        swipeMenuView.setSwipeEnable(false);
        Button delete_bt = (Button) findViewById(R.id.delete_bt);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intent, 1001);

            }
        });
        delete_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "删除", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == Activity.RESULT_OK) {
            String result = data.getStringExtra(CaptureActivity.KEY_DATA);
            Toast.makeText(this, "qrcode result is " + result, Toast.LENGTH_SHORT).show();
        }
    }


}
