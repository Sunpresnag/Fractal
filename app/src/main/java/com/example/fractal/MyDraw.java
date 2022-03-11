package com.example.fractal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyDraw extends View {
    public MyDraw(Context context) {
        super(context);
    }
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        tree(canvas, 500, 1000, 350, (float) Math.PI / 2);
        //fractal(canvas, 500,500,100);
    }

 //   void fractal(Canvas canvas, float x, float y, float r){
 //       if(r > 5){
 //           Paint p = new Paint();
 //           p.setStrokeWidth(1);
 //           p.setStyle(Paint.Style.STROKE);
 //           canvas.drawCircle(x,y,r, p);
 //           fractal(canvas, x, y - r, r / 2);
 //           fractal(canvas, x, y + r, r / 2);
 //           fractal(canvas, x - r, y, r / 2);
 //           fractal(canvas, x + r, y, r / 2);
 //       }
 //   }
    void tree(Canvas canvas, float x, float y, float d, float alp){
        if(d > 10){
            Paint p = new Paint();
            p.setStrokeWidth(3);
            float stopX = x + (float)Math.cos(alp) * d;
            float stopY = y - (float)Math.sin(alp) * d;
            canvas.drawLine(x, y, stopX, stopY, p);
            tree(canvas, stopX, stopY, d * 2 / 3, alp + (float)Math.PI / 9);
            tree(canvas, stopX, stopY, d * 2 / 3, alp - (float)Math.PI / 9);
            tree(canvas, stopX, stopY, d * 2 / 3, alp + 2 * (float)Math.PI / 9);
            tree(canvas, stopX, stopY, d * 2 / 3, alp - 2 * (float)Math.PI / 9);
        }
    }
}
