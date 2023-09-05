package com.example.mytravellingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


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
        Intent switchActivity = new Intent(this, flingAnimation.class);
        startActivity(switchActivity);
    }
}
