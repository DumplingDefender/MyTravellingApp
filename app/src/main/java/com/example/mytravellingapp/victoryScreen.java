package com.example.mytravellingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class victoryScreen extends AppCompatActivity {


    Button one;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
