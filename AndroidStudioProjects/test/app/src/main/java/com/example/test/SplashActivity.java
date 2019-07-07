package com.example.test;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler hd = new Handler();
        hd.postDelayed(new splashHandler(), 3000); // 1초 후에 hd handler 실행 3000ms = 3초
    }
    private class splashHandler implements  Runnable {
        public void run() {
            startActivity(new Intent(getApplication(), UserInfoActivity.class));
            SplashActivity.this.finish();
        }
    }

    @Override
    public void onBackPressed() {
        // 초반 스플래시 화면에서 넘어갈 때 뒤로가기 버튼 못 누르게 함
    }
}
