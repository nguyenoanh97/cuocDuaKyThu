package com.example.cuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

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
        CountDownTimer countDownTimer = new CountDownTimer(20000, 300) {
            @Override
            public void onTick(long millisUntilFinished) {
                int number = 5;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);
                // kiểm tra Win one
                if(skOne.getProgress() >= skOne.getMax()) {
                    ibtnPlay.setVisibility(View.VISIBLE);
                    this.cancel();
                    Toast.makeText(MainActivity.this, "One Win", Toast.LENGTH_SHORT).show();
                }
                // kiểm tra Win two
                if(skTwo.getProgress() >= skTwo.getMax()) {
                    ibtnPlay.setVisibility(View.VISIBLE);

                    this.cancel();
                    Toast.makeText(MainActivity.this, "Two Win", Toast.LENGTH_SHORT).show();
                }
                // kiểm tra Win three
                if(skThree.getProgress() >= skThree.getMax()) {
                    ibtnPlay.setVisibility(View.VISIBLE);

                    this.cancel();
                    Toast.makeText(MainActivity.this, "Three Win", Toast.LENGTH_SHORT).show();
                }

                skOne.setProgress(skOne.getProgress()+ one);
                skTwo.setProgress(skTwo.getProgress()+ two);
                skThree.setProgress(skThree.getProgress()+ three);

            }

            @Override
            public void onFinish() {

            }
        };
        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skOne.setProgress(0);
                skTwo.setProgress(0);
                skThree.setProgress(0);

                ibtnPlay.setVisibility(View.INVISIBLE);
                countDownTimer.start();
            }
        });

        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });


    }
    private void AnhXa() {
        txtDiem  = (TextView) findViewById(R.id.textviewDiemSo);
        cbOne    = (CheckBox) findViewById(R.id.checkboxOne);
        cbTwo    = (CheckBox) findViewById(R.id.checkboxTwo);
        cbThree  = (CheckBox) findViewById(R.id.checkboxThree);
        skOne    = (SeekBar) findViewById(R.id.seekbarOne);
        skTwo    = (SeekBar) findViewById(R.id.seekbarTwo);
        skThree  = (SeekBar) findViewById(R.id.seekbarThree);
        ibtnPlay = (ImageButton) findViewById(R.id.buttonlay);



    }
}