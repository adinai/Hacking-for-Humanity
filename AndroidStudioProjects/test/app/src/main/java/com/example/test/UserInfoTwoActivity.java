package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class UserInfoTwoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_two);

        ImageView image = findViewById(R.id.btnMoveToDaliAsk); /*페이지 전환버튼*/

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AlcoholDetectActivity.class));//액티비티 띄우기
            }
        });


        ImageView image2 = findViewById(R.id.btnMoveToDaliAsk2); /*페이지 전환버튼*/

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AlcoholDetectActivity.class));//액티비티 띄우기
            }
        });
    }
    @Override
    public void onBackPressed() {
        // 초반 userinfo 화면에서 넘어갈 때 뒤로가기 버튼 못 누르게 함
    }
}
