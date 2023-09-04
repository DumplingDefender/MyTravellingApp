package com.example.mytravellingapp;

import android.os.Bundle;
//import android.support.animation.DynamicAnimation;
//import android.support.animation.FlingAnimation;
//import android.support.v7.app.AppCompatActivity;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FlingAnimation;
import androidx.fragment.app.Fragment;

public class flingAnimation extends AppCompatActivity{

    private static final String TAG = flingAnimation.class.getSimpleName();

    private int maxTranslationX;
    private int maxTranslationY;
    private int extraHeight;

    ViewGroup mainLayout;
    ImageView soccerBall,field,goalie;

    FlingAnimation flingX;
    FlingAnimation flingY;
    private static float FLING_MIN_TRANSLATION = 430;
    private static final float FLING_FRICTION = 0.00001f;
    int boxWidthHalf;
    int boxHeightHalf;

    int yourGoals = 0;


    CountDownTimer countDownTimer;

    private long timeLeftInMills = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fling);

        mainLayout = findViewById(R.id.layout_main);
        soccerBall = (ImageView) findViewById(R.id.soccerBall);
        soccerBall.setImageResource(R.drawable.soccerballimg);
        field = (ImageView) findViewById(R.id.fieldImg);
        field.setImageResource(R.drawable.field);
        goalie = (ImageView) findViewById(R.id.goalieImg);
        goalie.setImageResource(R.drawable.goalie);

        soccerBall.setX(1000);
        soccerBall.setY(700);
        sendData();


        flingX = new FlingAnimation(soccerBall, DynamicAnimation.TRANSLATION_X);

        flingY = new FlingAnimation(soccerBall, DynamicAnimation.TRANSLATION_Y);

        final GestureDetector gestureDetector = new GestureDetector(this, mGestureListener);

        soccerBall.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });

        mainLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                maxTranslationX = 1770;
                maxTranslationY = mainLayout.getHeight() - soccerBall.getHeight();
                Log.d(TAG, "onGlobalLayout: maxTranslationX:" + maxTranslationX + " maxTranslationY:" + maxTranslationY);
                extraHeight = getPhoneHeight() - mainLayout.getHeight();
                //As only wanted the first call back, so now remove the listener
                mainLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

        soccerBall.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                boxWidthHalf = soccerBall.getWidth() / 2;
                boxHeightHalf = soccerBall.getHeight() / 2;
                soccerBall.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

        flingY.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean cancelled, float value, float velocity) {
                Log.d(TAG, "onAnimationEnd: ");
                Log.d(TAG, "cancelled: " + cancelled);
                Log.d(TAG, "value: " + value);
                Log.d(TAG, "velocity: " + velocity);
                cancelFling();
            }
        });

        flingX.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean cancelled, float value, float velocity) {
                Log.d(TAG, "onAnimationEnd: ");
                Log.d(TAG, "cancelled: " + cancelled);
                Log.d(TAG, "value: " + value);
                Log.d(TAG, "velocity: " + velocity);
                if(velocity<0) {
                    if (soccerBall.getX() <= 430) {
                        if (velocity > -1100) {
                            cancelFling();
                        }
                    }
                }
                if(velocity>0) {
                    if (soccerBall.getX() >= 1770) {
                        if (velocity < 1100) {
                            cancelFling();
                        }
                    }
                }
                cancelFling();
            }
        });

    }

    private GestureDetector.OnGestureListener mGestureListener = new GestureDetector.SimpleOnGestureListener() {

        //Constants
//        private static final int MIN_DISTANCE_MOVED = 50;
//        private static final float MIN_TRANSLATION = 0;
//        private static final float FRICTION = 1.1f;

        @Override
        public boolean onScroll(MotionEvent downEvent, MotionEvent moveEvent, float distanceX, float distanceY) {
            Log.d(TAG, "onScroll: @@@@@@@@@@@@@@@@@@@@@@@@@@@");
            Log.d(TAG, "distanceX:" + distanceX + " X:" + moveEvent.getX() + " RawX:" + moveEvent.getRawX());
            Log.d(TAG, "distanceY:" + distanceY + " Y:" + moveEvent.getY() + " RawY:" + moveEvent.getRawY());

            /*if (moveEvent.getRawX() >= boxWidthHalf && moveEvent.getRawX() <= (maxTranslationX + boxWidthHalf)) {
                ivBox.setTranslationX(moveEvent.getRawX() - boxWidthHalf);
            }

            if (moveEvent.getRawY() >= (ivBox.getHeight()) && moveEvent.getRawY() <= (maxTranslationY + ivBox.getHeight() - 20)) {
                ivBox.setTranslationY(moveEvent.getRawY() + extraHeight - boxHeightHalf);
            }*/

            return super.onScroll(downEvent, moveEvent, distanceX, distanceY);
        }

        @Override
        public boolean onDown(MotionEvent e) {
            Log.d(TAG, "onDown: ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            Log.d(TAG, "RawX: " + e.getRawX() + " X: " + e.getX());
            Log.d(TAG, "RawY: " + e.getRawY() + " NewY: " + (e.getRawY()) + " Y: " + e.getY());

            cancelFling();

//            if (e.getRawX() >= boxWidthHalf && e.getRawX() <= (maxTranslationX + boxWidthHalf)) {
//                soccerBall.setTranslationX(e.getRawX() - boxWidthHalf);
//            }
//
//            if (e.getRawY() >= (soccerBall.getHeight()) && e.getRawY() <= (maxTranslationY + soccerBall.getHeight() - 20)) {
//                soccerBall.setTranslationY(e.getRawY() + extraHeight - boxHeightHalf);
//            }

            return true;
        }

        @Override
        public boolean onFling(MotionEvent downEvent, MotionEvent moveEvent, float velocityX, float velocityY) {
            //downEvent : when user puts his finger down on the view
            //moveEvent : when user lifts his finger at the end of the movement
            float distanceInX = Math.abs(moveEvent.getRawX() - downEvent.getRawX());
            float distanceInY = Math.abs(moveEvent.getRawY() - downEvent.getRawY());

            Log.d(TAG, "onFling: >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            Log.d(TAG, "distanceInX : " + distanceInX + "\t" + "distanceInY : " + distanceInY);
//            if (soccerBall.getY() == 197) {
//                cancelFling();
//            }


            doFling(velocityX, velocityY);

            /*if (distanceInX > MIN_DISTANCE_MOVED) {
                //Fling Right/Left
                FlingAnimation flingX = new FlingAnimation(ivBox, DynamicAnimation.TRANSLATION_X);
                flingX.setStartVelocity(velocityX)
                        .setMinValue(FLING_MIN_TRANSLATION) // minimum translationX property
                        .setMaxValue(maxTranslationX)  // maximum translationX property
                        .setFriction(FLING_FRICTION)
                        .start();
            } else if (distanceInY > MIN_DISTANCE_MOVED) {
                //Fling Down/Up
                FlingAnimation flingY = new FlingAnimation(ivBox, DynamicAnimation.TRANSLATION_Y);
                flingY.setStartVelocity(velocityY)
                        .setMinValue(FLING_MIN_TRANSLATION)  // minimum translationY property
                        .setMaxValue(maxTranslationY) // maximum translationY property
                        .setFriction(FLING_FRICTION)
                        .start();
            }*/

            return true;
        }
    };

    private void cancelFling() {
        if (flingX.isRunning()) {
            flingX.cancel();
        }

        if (flingY.isRunning()) {
            flingY.cancel();
        }
    }

    private void doFling(float velocityX, float velocityY) {
        Log.d(TAG, "doFling: velocityX: " + velocityX + " velocityY:" + velocityY);
        cancelFling();

        /*if (velocityX <= 0 || velocityY <= 0) {
            return;
        }*/

        flingX.setStartVelocity(velocityX)
                .setMinValue(FLING_MIN_TRANSLATION) // minimum translationX property
                .setMaxValue(maxTranslationX)  // maximum translationX property
                .setFriction(FLING_FRICTION)
                .start();

        flingY.setStartVelocity(velocityY)
                .setMinValue(197)  // minimum translationY property
                .setMaxValue(700) //maximum translationY property
                .setFriction(FLING_FRICTION)
                .start();

        //X: 474,1770, 770, 1470
        //Y: 336, 695,
        int randNumX = (int) (Math.random()*1200)+450;
        Log.d(TAG,randNumX+"");
//        int randNumY = (int) (Math.random()*336)+359;
//        Log.d(TAG,randNumY+"");
//        goalie.setY(randNumY);
        goalie.setX(randNumX);
        yourGoals++;

        countDownTimer = new CountDownTimer(timeLeftInMills,1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMills = 1;
            }

            @Override
            public void onFinish() {
                countDownTimer.cancel();
                soccerBall.setX(1000);
                soccerBall.setY(700);
                timeLeftInMills = 3000;

            }
        }.start();
        sendData();
    }

    public void sendData(){
        Bundle bundle = new Bundle();

        bundle.putInt("yourGoals",yourGoals);

        Fragment fragment = new score();

        fragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView,fragment)
                .commit();
    }



    private int getPhoneHeight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        //int width = displayMetrics.widthPixels;
        return height;
    }

//    private void oldMethod() {
//        final FlingAnimation flingAnimation = new FlingAnimation(ivBox, DynamicAnimation.TRANSLATION_Y);
//        flingAnimation.setStartVelocity(2000);
//        flingAnimation.setFriction(0.000001f);
//        flingAnimation.setMinValue(0);
//        flingAnimation.setMaxValue(1500);
//
//        ivBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (flingAnimation.isRunning()) {
//                    flingAnimation.cancel();
//                } else {
//                    flingAnimation.start();
//                }
//            }
//        });
//
//        flingAnimation.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
//            @Override
//            public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean cancelled, float value, float velocity) {
//                Log.d(TAG, "onAnimationEnd: ");
//                Log.d(TAG, "cancelled: " + cancelled);
//                Log.d(TAG, "value: " + value);
//                Log.d(TAG, "velocity: " + velocity);
//                flingAnimation.cancel();
//            }
//        });
//
//        flingAnimation.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
//            @Override
//            public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float value, float velocity) {
//                Log.d(TAG, "onAnimationUpdate: v : " + value);
//                Log.d(TAG, "onAnimationUpdate: v1 : " + velocity);
//            }
//        });
//    }

}
