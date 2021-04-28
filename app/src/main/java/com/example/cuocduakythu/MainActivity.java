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
    int soDiem = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        // Không cho tương tác seekbar
        skOne.setEnabled(false);
        skTwo.setEnabled(false);
        skThree.setEnabled(false);

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
                    if(cbOne.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác", Toast.LENGTH_SHORT).show();

                    }else {
                        soDiem -= 5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi", Toast.LENGTH_SHORT).show();

                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                }
                // kiểm tra Win two
                if(skTwo.getProgress() >= skTwo.getMax()) {
                    ibtnPlay.setVisibility(View.VISIBLE);

                    this.cancel();
                    Toast.makeText(MainActivity.this, "Two Win", Toast.LENGTH_SHORT).show();
                    if(cbTwo.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác", Toast.LENGTH_SHORT).show();
                    }else {
                        soDiem -= 5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                }
                // kiểm tra Win three
                if(skThree.getProgress() >= skThree.getMax()) {
                    ibtnPlay.setVisibility(View.VISIBLE);

                    this.cancel();
                    Toast.makeText(MainActivity.this, "Three Win", Toast.LENGTH_SHORT).show();
                    if(cbThree.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác", Toast.LENGTH_SHORT).show();

                    }else {
                        soDiem -= 5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi", Toast.LENGTH_SHORT).show();

                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
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
                if(cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked()){

                skOne.setProgress(0);
                skTwo.setProgress(0);
                skThree.setProgress(0);
                ibtnPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    DisableCheckBox();
             }else{
                    Toast.makeText(MainActivity.this, "Vui lòng đặt cược trước khi chơi", Toast.LENGTH_SHORT).show();
                }
            }
        });
//Không cho tương tác checkbox khi đang chạy
        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cbTwo.setChecked(false);
                cbThree.setChecked(false);

            }
        });
        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cbOne.setChecked(false);
                cbThree.setChecked(false);

            }
        });
        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cbTwo.setChecked(false);
                cbOne.setChecked(false);

            }
        });


    }
    private void EnableCheckBox() {
        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbThree.setEnabled(true);
    }
    private void DisableCheckBox() {
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);
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