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

    float rand(float min , float max){
        return (float)(Math.random() * (max - min + 1)) + min;
    }

    void fillRandom(float[] array , float min, float max){
        for (int i = 0; i < array.length; i++){
            array[i] = rand (min, max);
        }
    }

    MyView(Context context) {
        super(context);
        fillRandom(x, 0, 500);
        fillRandom(y, 0, 500);
        fillRandom(vx, -3, 3);
        fillRandom(vy, 500,-5);

    }

    void add(float[] array , float[] values){
        for (int i = 0; i < array.length; i++){
            array[i] += values[i];
        }
    }
    /*void drawBalls(Canvas canvas){
        for (int i = 0; i < N; i++) {
            canvas.drawCircle(x[i], y[i], 20, paint);
        }
    }*/

    Paint paint = new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        // отрисовываем все шарики
        for (int i = 0; i < N; i++) {
            canvas.drawCircle(x[i], y[i], 20, paint);
        }
        // готовим массивы x и у для следущего кадра
        add(x, vx);
        add(y, vy);
        //запрашиваем перерисовку
        invalidate();
    }
}
