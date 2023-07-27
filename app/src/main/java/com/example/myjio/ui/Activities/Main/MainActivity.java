package com.example.myjio.ui.Activities.Main;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.myjio.R;
import com.example.myjio.core.Adapters.SliderHome1;

public class MainActivity extends AppCompatActivity {

    private ViewPager top_slider;
    private LinearLayout top_dot_slider;
    private int dotscount;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Integer[] images = {R.drawable.img_banner_comming_soon, R.drawable.img_banner_computer, R.drawable.img_banner_sale, R.drawable.img_banner_sale_80off};

        top_slider = findViewById(R.id.top_slider);
        top_dot_slider = findViewById(R.id.top_dot_slider);

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

}