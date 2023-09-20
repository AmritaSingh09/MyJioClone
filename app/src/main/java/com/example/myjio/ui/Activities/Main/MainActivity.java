package com.example.myjio.ui.Activities.Main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.myjio.R;
import com.example.myjio.core.Adapters.SliderHome1;

public class MainActivity extends AppCompatActivity {

    //bottom container views
    private LinearLayout v_home, v_recharge, v_music, v_care, v_menu;

    //top container views
    private ImageView v_qr, v_voice;
    private RelativeLayout v_notification, v_search;
    private TextView v_txt_notification, v_search_txt;

    //middle container views
    private ViewPager top_slider;
    private LinearLayout top_dot_slider;

    //global variables
    private int dotscount;
    private ImageView[] dots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        v_care.setOnClickListener(care_view ->  startActivity(new Intent(MainActivity.this, CustomerSupport.class)));
        v_music.setOnClickListener(care_view ->  startActivity(new Intent(MainActivity.this, Music.class)));
        v_recharge.setOnClickListener(care_view ->  startActivity(new Intent(MainActivity.this, Recharge.class)));

        Integer[] images = {R.drawable.img_banner_comming_soon, R.drawable.img_banner_computer, R.drawable.img_banner_sale, R.drawable.img_banner_sale_80off};

        SliderHome1 top_slider_adapter = new SliderHome1(this,images);
        top_slider.setClipToPadding(false);
        top_slider.setPadding(50,0,150,0);
        top_slider.setAdapter(top_slider_adapter);

        dotscount = top_slider_adapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            top_dot_slider.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        top_slider.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private synchronized void initViews() {
        // top views
        v_qr = findViewById(R.id.home_qr_icon);
        v_notification = findViewById(R.id.home_notification);
        v_txt_notification = findViewById(R.id.no_of_notification);
        v_search = findViewById(R.id.home_search_view);
        v_voice = findViewById(R.id.home_voice_search);
        v_search_txt = findViewById(R.id.home_search_text);

        // bottom views
        v_home = findViewById(R.id.v_home);
        v_music = findViewById(R.id.v_music);
        v_recharge = findViewById(R.id.v_recharge);
        v_care = findViewById(R.id.v_care);
        v_menu = findViewById(R.id.v_menu);

        //middle views
        top_slider = findViewById(R.id.top_slider);
        top_dot_slider = findViewById(R.id.top_dot_slider);

    }

}