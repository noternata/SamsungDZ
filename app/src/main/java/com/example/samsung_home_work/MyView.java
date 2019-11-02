package com.example.samsung_home_work;


import android.content.Context;
import android.graphics.*;
import android.view.View;


public class MyView extends View {
    int N = 10; // количество шариков
    float[] x  = new float[N];
    float[] y  = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];

   public MyView(Context context) {
       super(context);
       for (int i = 0; i < N; i++){
           x[i] = (float)(Math.random() * 500);
           y[i] = (float)(Math.random() * 500);
           vx[i] = (float)(Math.random() * 6 - 3);
           vy[i] = (float)(Math.random() * 6 - 3);
       }
   }
    Paint paint = new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < N; i++) {
            canvas.drawCircle(x[i], y[i], 20, paint);
        }
        for (int i = 0; i < N; i++) {
            x[i] += vx[i];
            y[i] += vy[i];
        }
        invalidate();
    }
}