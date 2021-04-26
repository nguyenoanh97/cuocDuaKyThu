package com.example.cuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtDiem;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar skOne, skTwo, skThree;
    ImageButton ibtnPlay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        CountDownTimer countDownTimer = new CountDownTimer(10000, 300) {
            @Override
            public void onTick(long millisUntilFinished) {
                skOne.setProgress(skOne.getProgress()+ 5);
                skTwo.setProgress(skTwo.getProgress()+ 5);
                skThree.setProgress(skThree.getProgress()+ 5);

            }

            @Override
            public void onFinish() {

            }
        };
        ibtnPlay

    }
    private void AnhXa() {
        txtDiem = (TextView) findViewById(R.id.textviewDiemSo);
        cbOne = (CheckBox) findViewById(R.id.checkboxOne);
        cbTwo = (CheckBox) findViewById(R.id.checkboxTwo);
        cbThree = (CheckBox) findViewById(R.id.checkboxThree);
        skOne = (SeekBar) findViewById(R.id.seekbarOne);
        skTwo = (SeekBar) findViewById(R.id.seekbarTwo);
        skThree = (SeekBar) findViewById(R.id.seekbarThree);
        ibtnPlay = (ImageButton) findViewById(R.id.buttonlay);



    }
}