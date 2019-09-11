package com.example.gse.inshortdemo.widget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 *
 */
public class SwipeListener implements View.OnTouchListener
{
    private final GestureDetector gestureDetector;

    public SwipeListener(Context ctx){
        gestureDetector = new GestureDetector(ctx, new MyGestureListener());
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    /**
     *
     */
    private final class MyGestureListener extends GestureDetector.SimpleOnGestureListener
    {
        @Override
        public boolean onDown(MotionEvent e)
        {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > 30) {
                        if (diffX > 0) {
                            swipeLeft();
                        } else {
                            swipeRight();
                        }
                        result = true;
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }

    public void swipeRight() {
    }

    public void swipeLeft() {
    }
}
