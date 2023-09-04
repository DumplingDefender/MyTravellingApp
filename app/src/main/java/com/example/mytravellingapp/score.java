package com.example.mytravellingapp;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class score extends Fragment {

    private static final String TAG = flingAnimation.class.getSimpleName();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    CheckBox checkBox,checkBox2,checkBox3,checkBox4,checkBox5,
            checkBox6,checkBox7,checkBox8,checkBox9,checkBox10;
    boolean yourGoal1,yourGoal2,yourGoal3,yourGoal4,yourGoal5 = false;
    boolean opponentGoal1,opponentGoal2,opponentGoal3,opponentGoal4,opponentGoal5 = false;

    int attempts = 0;

    int opAttempts = 0;

    public score() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment score.
     */
    // TODO: Rename and change types and number of parameters


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score, container, false);

        checkBox = view.findViewById(R.id.checkBox);
        checkBox2 = view.findViewById(R.id.checkBox2);
        checkBox3 = view.findViewById(R.id.checkBox3);
        checkBox4 = view.findViewById(R.id.checkBox4);
        checkBox5 = view.findViewById(R.id.checkBox5);

        checkBox6 = view.findViewById(R.id.checkBox6);
        checkBox7 = view.findViewById(R.id.checkBox7);
        checkBox8 = view.findViewById(R.id.checkBox8);
        checkBox9 = view.findViewById(R.id.checkBox9);
        checkBox10 = view.findViewById(R.id.checkBox10);

        if(getArguments()!=null){
            yourGoal1 = getArguments().getBoolean("yourGoal1");
            yourGoal2 = getArguments().getBoolean("yourGoal2");
            yourGoal3 = getArguments().getBoolean("yourGoal3");
            yourGoal4 = getArguments().getBoolean("yourGoal4");
            yourGoal5 = getArguments().getBoolean("yourGoal5");

            attempts = getArguments().getInt("attempts");

            opponentGoal1 = getArguments().getBoolean("opponentGoal1");
            opponentGoal2 = getArguments().getBoolean("opponentGoal2");
            opponentGoal3 = getArguments().getBoolean("opponentGoal3");
            opponentGoal4 = getArguments().getBoolean("opponentGoal4");
            opponentGoal5 = getArguments().getBoolean("opponentGoal5");

            opAttempts = getArguments().getInt("opAttempts");

            if(getArguments().getInt("reset")==0){
                checkBox.setBackgroundColor(Color.TRANSPARENT);
                checkBox2.setBackgroundColor(Color.TRANSPARENT);
                checkBox3.setBackgroundColor(Color.TRANSPARENT);
                checkBox4.setBackgroundColor(Color.TRANSPARENT);
                checkBox5.setBackgroundColor(Color.TRANSPARENT);

                checkBox6.setBackgroundColor(Color.TRANSPARENT);
                checkBox7.setBackgroundColor(Color.TRANSPARENT);
                checkBox8.setBackgroundColor(Color.TRANSPARENT);
                checkBox9 .setBackgroundColor(Color.TRANSPARENT);
                checkBox10.setBackgroundColor(Color.TRANSPARENT);

                checkBox.setChecked(false);
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
                checkBox4.setChecked(false);
                checkBox5.setChecked(false);

                checkBox6.setChecked(false);
                checkBox7.setChecked(false);
                checkBox8.setChecked(false);
                checkBox9 .setChecked(false);
                checkBox10.setChecked(false);

            }
        }

        if(yourGoal1&&attempts>=1){
            checkBox.setChecked(true);
        }else if(attempts>=1){
            checkBox.setBackgroundColor(Color.RED);
        }

        if(yourGoal2&&attempts>=2){
            checkBox2.setChecked(true);
        }else if(attempts>=2){
            checkBox2.setBackgroundColor(Color.RED);
        }

        if(yourGoal3&&attempts>=3){
            checkBox3.setChecked(true);
        }else if(attempts>=3){
            checkBox3.setBackgroundColor(Color.RED);
        }

        if(yourGoal4&&attempts>=4){
            checkBox4.setChecked(true);
        }else if(attempts>=4){
            checkBox4.setBackgroundColor(Color.RED);
        }

        if(yourGoal5&&attempts>=5){
            checkBox5.setChecked(true);
        }else if(attempts>=5){
            checkBox5.setBackgroundColor(Color.RED);
        }
//**************************************************************************
        if(opponentGoal1&&opAttempts>=1){
            checkBox6.setChecked(true);
        }else if(opAttempts>=1){
            checkBox6.setBackgroundColor(Color.RED);
        }
        if(opponentGoal2&&opAttempts>=2){
            checkBox7.setChecked(true);
        }else if(opAttempts>=2){
            checkBox7.setBackgroundColor(Color.RED);
        }

        if(opponentGoal3&&opAttempts>=3){
            checkBox8.setChecked(true);
        }else if(opAttempts>=3){
            checkBox8.setBackgroundColor(Color.RED);
        }

        if(opponentGoal4&&opAttempts>=4){
            checkBox9.setChecked(true);
        }else if(opAttempts>=4){
            checkBox9.setBackgroundColor(Color.RED);
        }

        if(opponentGoal5&&opAttempts>=5){
            checkBox10.setChecked(true);
        }else if(opAttempts>=5){
            checkBox10.setBackgroundColor(Color.RED);
        }




        // Inflate the layout for this fragment
        return view;
    }
}