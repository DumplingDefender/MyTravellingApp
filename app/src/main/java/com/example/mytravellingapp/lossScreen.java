package com.example.mytravellingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class lossScreen extends AppCompatActivity {


    Button one;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loss);

        one =  findViewById(R.id.one);
        one.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                switchActivties();
            }
        });
    }

    public void switchActivties(){
        Intent switchActivity = new Intent(this, IntroActivity.class);
        startActivity(switchActivity);
    }
}
