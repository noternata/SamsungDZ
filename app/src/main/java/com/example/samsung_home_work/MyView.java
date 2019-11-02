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
        int y = 0;
        while (y < canvas.getHeight()) {
            canvas.drawLine( 0, y,
                    this.getWidth()-70, y-70, paint);
            y += 30;
        }
    }
}