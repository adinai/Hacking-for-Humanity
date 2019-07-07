package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.Locale;

public class AlcoholDetectActivity extends AppCompatActivity {

    private static final long START_TIME_IN_MILLIS = 10000;
    private TextView mTextViewCountDown;
    private CountDownTimer mCountDownTimer;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    LinearLayout daliBtnLL;
    LinearLayout daliTimeLL;

    TextView tv1;
    TextView tv2;

    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dali_ask);

        daliBtnLL = findViewById(R.id.dali_btn_ll);
        daliTimeLL = findViewById(R.id.dali_time_ll);

        tv1 = findViewById(R.id.textToModify);
        tv2 = findViewById(R.id.textToModify2);

        imageview = findViewById(R.id.myAvatar);

        Button btnDetect = findViewById(R.id.btnDetect); //페이지 전환버튼
        final Button btnDali = findViewById(R.id.btnDali);
        final Button btnDali2 = findViewById(R.id.btnDali2);

        btnDetect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.addFlags();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));//액티비티 띄우기
            }
        });

        btnDali2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FinishActivity.class));//액티비티 띄우기
            }
        });

        btnDali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    daliBtnLL.setVisibility(View.GONE);
                    daliTimeLL.setVisibility(View.VISIBLE);

                    mTextViewCountDown = findViewById(R.id.text_view_countdown);
                    startTimer();
                    updateCountDownText();
            }
        });

        Globals g = (Globals)getApplication();
        float val = g.getData();

        tv2.setText(String.valueOf(val));

        if ( val == 0 ){
            imageview.setImageResource(R.drawable.image);
        }
        else if ( val < 0.03 ){
            imageview.setImageResource(R.drawable.image_4);
            tv1.setText(R.string.detect_oneshot);
            tv2.setVisibility(View.VISIBLE);
            btnDali.setVisibility(View.GONE);
            btnDali2.setVisibility(View.VISIBLE);
        }
        else if ( val < 0.08 ){
            imageview.setImageResource(R.drawable.image_5);
            tv1.setText(R.string.detect_cancel);
            tv2.setVisibility(View.VISIBLE);
            btnDali.setVisibility(View.GONE);
            btnDali2.setVisibility(View.VISIBLE);
        }
        else {
            imageview.setImageResource(R.drawable.image_6);
            tv1.setText(R.string.detect_stop);
            tv2.setVisibility(View.VISIBLE);
            btnDali.setVisibility(View.GONE);
            btnDali2.setVisibility(View.VISIBLE);
        }
    }

    protected void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                daliBtnLL.setVisibility(View.VISIBLE);
                daliTimeLL.setVisibility(View.GONE);
                startActivity(new Intent(getApplicationContext(), MainActivity.class));//액티비티 띄우기
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);
    }
}
