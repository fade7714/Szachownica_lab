package com.example.szachownica_lab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import static java.lang.Math.min;

public class Panel extends View{
    private Paint paintLight;
    private Paint paintDark;
    private boolean defaultColors = true;
    public Panel(Context context){
        super(context);
        init();
    }
    public Panel(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        init();
    }
    public Panel(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init();
    }
    private  void init(){
        paintLight = new Paint();
        paintLight.setAntiAlias(true);
        paintLight.setStyle(Paint.Style.FILL);
        paintLight.setColor(0xFFFFFFFF);

        paintDark = new Paint();
        paintDark.setAntiAlias(true);
        paintDark.setStyle(Paint.Style.FILL);
        paintDark.setColor(0xFF000000);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        int w = getWidth();
        int h = getHeight();
        int boardSize = min(w, h);

        float squareSize = (float) boardSize / 8f;
        float startX = (w - boardSize) / 2f;
        float startY = (h - boardSize) / 2f;

        for(int row = 0; row < 8; row++){
            for (int col = 0; col < 8; col++){
                boolean dark = ((row + col) % 2 == 0);
                float left = startX + col * squareSize;
                float top = startY + row * squareSize;
                float right = left + squareSize;
                float bottom = top + squareSize;
                canvas.drawRect(left, top, right, bottom, dark ? paintDark : paintLight);
            }
        }
    }
    public void setBlackWhiteColors(){
        paintLight.setColor(0xFFFFFFFF);
        paintDark.setColor(0xFF000000);
        invalidate();
    }
    public void setRedYellowColors(){
        paintLight.setColor(0xFFFFFF00);
        paintDark.setColor(0xFFFF0000);
        invalidate();
    }
}
