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

    CheckBox checkBox,checkBox2;
    int yourGoals = 0;

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

        if(getArguments()!=null){
            yourGoals = getArguments().getInt("yourGoals");
        }

        if(yourGoals>0){
            checkBox.setChecked(true);
        }
        if(yourGoals>1){

            checkBox2.setBackgroundColor(Color.RED);
        }

        Log.d(TAG,yourGoals+"");

        // Inflate the layout for this fragment
        return view;
    }
}