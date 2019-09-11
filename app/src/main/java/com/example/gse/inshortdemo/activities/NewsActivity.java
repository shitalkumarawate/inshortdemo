package com.example.gse.inshortdemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.example.gse.inshortdemo.R;
import com.example.gse.inshortdemo.adpater.VPagerAdapter;
import com.example.gse.inshortdemo.widget.SwipeListener;
import com.example.gse.inshortdemo.widget.VerticalViewPager;

public class NewsActivity extends AppCompatActivity
{
    private VerticalViewPager verticalViewPager;
    private static final String DEBUG_TAG = NewsActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        try {
            this.requestWindowFeature(Window.FEATURE_NO_TITLE);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_news);

            verticalViewPager = findViewById(R.id.vertical_view_pager);
            verticalViewPager.setAdapter(new VPagerAdapter(this));

            verticalViewPager.setOnTouchListener(new SwipeListener(this) {
                @Override
                public void swipeRight() {
                    startActivity(new Intent(NewsActivity.this, ActivityOne.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }

                @Override
                public void swipeLeft() {
                    startActivity(new Intent(NewsActivity.this, ActivityTwo.class));
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /*@Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
        int action = ev.getAction();
        switch(action) {
            case (MotionEvent.ACTION_DOWN):
                Log.d(DEBUG_TAG, "Action was DOWN");
                return true;
            case (MotionEvent.ACTION_MOVE):
                Log.d(DEBUG_TAG, "Action was MOVE");
                return true;
            case (MotionEvent.ACTION_UP):
                Log.d(DEBUG_TAG, "Action was UP");
                return true;
            case (MotionEvent.ACTION_CANCEL):
                Log.d(DEBUG_TAG, "Action was CANCEL");
                return true;
            default:
                return super.dispatchTouchEvent(ev);
        }
    }*/

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }*/
}
