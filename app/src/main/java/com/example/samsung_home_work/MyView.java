package com.example.samsung_home_work;


import android.content.Context;
import android.graphics.*;
import android.view.View;


public class MyView extends View {

   MyView(Context context) {
       super(context);
   }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(100, 100, 300, 300, paint);
    }
}

