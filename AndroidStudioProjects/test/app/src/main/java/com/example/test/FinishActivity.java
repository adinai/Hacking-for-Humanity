package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class FinishActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_noti);

        Button button = findViewById(R.id.btnShowFinish); /*페이지 전환버튼*/

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout finPage = findViewById(R.id.finishPage); /*페이지 전환버튼*/
                finPage.setVisibility(View.VISIBLE);
            }
        });
    }
    @Override
    public void onBackPressed() {
        // 초반 userinfo 화면에서 넘어갈 때 뒤로가기 버튼 못 누르게 함
    }
}
