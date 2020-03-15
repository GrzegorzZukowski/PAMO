package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WhatCanIEat extends AppCompatActivity {

    private Button mBtGoBack;
    private TextView text;
    private String bmi;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_can_i_eat);

        Intent incomingIntent = getIntent();

        mBtGoBack = findViewById(R.id.goBackBtn);

        text = findViewById(R.id.HowManyKcal);
        imageView= findViewById(R.id.obraz);
        bmi= incomingIntent.getStringExtra("DietOptions");
        bmi = bmi.substring(0,4);
        //text.setText(bmi);

        displayDiet(bmi);
        mBtGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void displayDiet(String data){

        //TODO zrobić przepisy

        float bmi = Float.valueOf(data);
        if(bmi <=15.5){
            text.setText(R.string.eat_alot);
            imageView.setImageResource(R.drawable.food1);
        }
        else if(bmi>15.5 && bmi<=25){
            text.setText(R.string.stay_like_that);
            imageView.setImageResource(R.drawable.zbilansow);
        }
        else{
            text.setText(R.string.loose_weight_fatty);
            imageView.setImageResource(R.drawable.download);
        }
    }
}
