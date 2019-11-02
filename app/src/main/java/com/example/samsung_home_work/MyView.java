package com.example.samsung_home_work;


import android.content.Context;
import android.graphics.*;
import android.view.View;

import java.util.Random;


public class MyView extends View {
    int N = (int) (Math.random() * 50); // количество шариков
    float[] x  = new float[N];
    float[] y  = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];

   public MyView(Context context) {
       super(context);
       for (int i = 0; i < N; i++){
           x[i] = (float)(Math.random() * 500);
           y[i] = (float)(Math.random() * 500);
           vx[i] = (float)(Math.random() * 12 - 3);
           vy[i] = (float)(Math.random() * 12 - 3);
       }
   }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();

        for (int i = 0; i < N; i++) {
            if ((x[i] < 0 || x[i] > this.getWidth()) || (y[i] < 0 || y[i] > this.getHeight())){
                paint.setColor(Color.argb(0,0,0,0));
            }
            else {
                paint.setColor(Color.RED);
            }
        }
        // отрисовываем все шарики
        for (int i = 0; i < N - 1; i++) {

            canvas.drawLine(x[i], y[i], x[i + 1], y[i + 1], paint);

        }
        // готовим массивы x и у для следущего кадра
        for (int i = 0; i < N; i++) {
            x[i] += vx[i];
            y[i] += vy[i];
            if (x[i] < 0 || x[i] > this.getWidth()){
                vx[i] = - vx[i];
                //paint.setColor(Color.argb(0,0,0,0));
            }
            if (y[i] < 0 || y[i] > this.getHeight()) {
                vy[i] = -vy[i];
            }

            if ((x[i] < 0 || x[i] > this.getWidth()) && (y[i] < 0 || y[i] > this.getHeight())) {

                vx[i] = rand(0 , this.getWidth());

                vy[i] = rand(0, this.getHeight());

            }
        }
        //запрашиваем перерисовку
        invalidate();
    }

    float rand (float start, float end) {
        return (float) (Math.random() * end);
    }
}

