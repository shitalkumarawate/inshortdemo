package com.example.gse.inshortdemo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.gse.inshortdemo.R;
import com.example.gse.inshortdemo.widget.SwipeListener;

public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        findViewById(R.id.rel_lay_container).setOnTouchListener(new SwipeListener(this) {
            @Override
            public void swipeRight() {
                super.swipeRight();
                finish();
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
