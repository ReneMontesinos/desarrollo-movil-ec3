package com.idat.ec3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    ViewPager mSLideViewPager;
    LinearLayout mDotLayout;
    Button skipbtn, getStartedBtn;

    TextView[] dots;

    ImageView imageView;

    ConstraintLayout constraintLayout;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skipbtn = findViewById(R.id.skipButton);
        getStartedBtn = findViewById(R.id.starter_btn);


        skipbtn.setOnClickListener(v -> {


            Intent i = new Intent(MainActivity.this, MainScreen.class);
            startActivity(i);
            finish();

        });

        getStartedBtn.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, MainScreen.class);
            startActivity(i);
            finish();
        });


        mSLideViewPager = findViewById(R.id.slideViewPager);
        mDotLayout = findViewById(R.id.indicator_layout);

        viewPagerAdapter = new ViewPagerAdapter(this);

        mSLideViewPager.setAdapter(viewPagerAdapter);

        setUpindicator(0);
        mSLideViewPager.addOnPageChangeListener(viewListener);

    }



    public void setUpindicator(int position) {

        dots = new TextView[3];
        mDotLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {

            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.inactive, getApplicationContext().getTheme()));
            mDotLayout.addView(dots[i]);

        }

        constraintLayout = findViewById(R.id.constraintLayout);
        if (position == 1) {
            constraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.coral));

        } else {
            constraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        }


        dots[position].setTextColor(getResources().getColor(R.color.black, getApplicationContext().getTheme()));

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            if (position == 1) {


            }
            setUpindicator(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private int getitem(int i){

        return mSLideViewPager.getCurrentItem() + i;
    }
}