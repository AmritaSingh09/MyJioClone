package com.example.myjio.ui.Activities.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myjio.R;
import com.example.myjio.core.Utils.login;
import com.example.myjio.ui.Activities.Main.MainActivity;

public class FirstPage extends AppCompatActivity {

    private ImageView c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14;
    private TextView c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        //TODO: HIDE STATUS BAR MAKE SCREEN FULL SCREEN
        initViews();
        loadAnimation();
        loadAll();
    }


    private void loadAll() {

        new Handler().postDelayed(() -> {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.zoom);
            c9.startAnimation(animation);
            c9.setVisibility(View.VISIBLE);
            c2.startAnimation(animation);
            c2.setVisibility(View.VISIBLE);
            c12.startAnimation(animation);
            c12.setVisibility(View.VISIBLE);
            c14.startAnimation(animation);
            c14.setVisibility(View.VISIBLE);
            c4.startAnimation(animation);
            c4.setVisibility(View.VISIBLE);

        },500);

        new Handler().postDelayed(() -> {
            Animation animation = AnimationUtils.loadAnimation(this,R.anim.zoom);
            c1.startAnimation(animation);
            c1.setVisibility(View.VISIBLE);
            c5.startAnimation(animation);
            c5.setVisibility(View.VISIBLE);
            c10.startAnimation(animation);
            c10.setVisibility(View.VISIBLE);

        },750);

        new Handler().postDelayed(() -> {
            Animation animation = AnimationUtils.loadAnimation(this,R.anim.zoom);
            c11.startAnimation(animation);
            c11.setVisibility(View.VISIBLE);
            c6.startAnimation(animation);
            c6.setVisibility(View.VISIBLE);
            c8.startAnimation(animation);
            c8.setVisibility(View.VISIBLE);
        },1000);


        new Handler().postDelayed(() -> {
            if (new login().isLogin()) {
                startActivity(new Intent(this, MainActivity.class));
            }else Toast.makeText(this, "Not Authenticated!", Toast.LENGTH_SHORT).show();
            finish();
        },2000);
    }

    private void loadAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.zoom);

        c.startAnimation(animation);
        c.setVisibility(View.VISIBLE);
        c3.startAnimation(animation);
        c3.setVisibility(View.VISIBLE);
        c7.startAnimation(animation);
        c7.setVisibility(View.VISIBLE);
        c13.startAnimation(animation);
        c13.setVisibility(View.VISIBLE);


    }

    private synchronized void initViews() {
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        c7 = findViewById(R.id.c7);
        c8 = findViewById(R.id.c8);
        c9 = findViewById(R.id.c9);
        c10 = findViewById(R.id.c10);
        c11 = findViewById(R.id.c11);
        c12 = findViewById(R.id.c12);
        c13 = findViewById(R.id.c13);
        c14 = findViewById(R.id.c14);
        c = findViewById(R.id.c);
    }
}