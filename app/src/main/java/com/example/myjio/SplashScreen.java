package com.example.myjio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myjio.core.Utils.login;

public class SplashScreen extends AppCompatActivity {

    private ImageView c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14;
    private TextView c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initViews();
        //todo: zoom animation to the circles
        new Handler().postDelayed(() -> {
            if (new login().isLogin()) {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
            }else Toast.makeText(this, "Not Authenticated!", Toast.LENGTH_SHORT).show();
            finish();
        },2000);

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