package com.example.samsung_home_work;


import android.content.Context;
import android.graphics.*;
import android.view.View;


public class MyView extends View {

   MyView(Context context) {
       super(context);
   }
    Paint paint = new Paint();
    float x = 0;
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(x, 300, 20, paint);
        x += 0.5f;
        invalidate();
    }
}