package com.example.brandon.doodleapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Brandon on 3/22/2016.
 */
public class DoodleView extends View {
    private Paint paintDoodle = new Paint();
    private Path path = new Path();
    private Path p2 = new Path();
    private Path p3 = new Path();
    private Path p4 = new Path();
    private boolean cc = false;
    private HashMap<Path, Paint> paths = new HashMap<Path, Paint>();
    int size = 10;
    int opacity = 255;
    int color = Color.RED;
    boolean quad = false;

    public DoodleView(Context context) {
        super(context);
        init(null, 0);
    }

    public DoodleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public DoodleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        paintDoodle.setColor(color);
        paintDoodle.setAntiAlias(true);
        paintDoodle.setStrokeWidth(size);
        paintDoodle.setStyle(Paint.Style.STROKE);
        paintDoodle.setAlpha(opacity);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (cc) {
            Path p = new Path();
            Paint clearPaint = new Paint();
            clearPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            canvas.drawRect(0, 0, 0, 0, clearPaint);
            cc = false;
            paths.clear();
            path = new Path();
            p2 = new Path();
            p3 = new Path();
            p4 = new Path();
        } else {
            for (Path p : paths.keySet()) {
                canvas.drawPath(p, paths.get(p));
            }
            if (quad) {
                canvas.drawPath(p2, paintDoodle);
                canvas.drawPath(p3, paintDoodle);
                canvas.drawPath(p4, paintDoodle);
            }
            canvas.drawPath(path, paintDoodle);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float touchX = motionEvent.getX();
        float touchY = motionEvent.getY();

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (quad) {
                    p2.moveTo(touchX, 885 - touchY);
                    p3.moveTo(getWidth() - touchX, touchY);
                    p4.moveTo(getWidth() - touchX, 885 - touchY);
                }
                path.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                if (quad) {
                    p2.lineTo(touchX, 885 - touchY);
                    p3.lineTo(getWidth() - touchX, touchY);
                    p4.lineTo(getWidth() - touchX, 885 - touchY);
                }
                path.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        invalidate();
        return true;
    }

    public void clear() {
        cc = true;
        invalidate();
    }

    public int getColor() {
        return paintDoodle.getColor();
    }

    public void setColor(int colorIn) {
        color = colorIn;
        if (quad) {
            paths.put(path, paintDoodle);
            paths.put(p2, paintDoodle);
            paths.put(p3, paintDoodle);
            paths.put(p4, paintDoodle);
            p2 = new Path();
            p3 = new Path();
            p4 = new Path();
        } else {
            paths.put(path, paintDoodle);
        }
        path = new Path();
        paintDoodle = new Paint();
        paintDoodle.setColor(color);
        paintDoodle.setAntiAlias(true);
        paintDoodle.setStyle(Paint.Style.STROKE);
        paintDoodle.setStrokeWidth(size);
        paintDoodle.setAlpha(opacity);
    }

    public void setOpacity(int opacityIn) {
        opacity = opacityIn < 50 ? 50 : opacityIn;
        if (quad) {
            paths.put(path, paintDoodle);
            paths.put(p2, paintDoodle);
            paths.put(p3, paintDoodle);
            paths.put(p4, paintDoodle);
            p2 = new Path();
            p3 = new Path();
            p4 = new Path();
        } else {
            paths.put(path, paintDoodle);
        }
        path = new Path();
        paintDoodle = new Paint();
        paintDoodle.setAntiAlias(true);
        paintDoodle.setStyle(Paint.Style.STROKE);
        paintDoodle.setColor(color);
        paintDoodle.setStrokeWidth(size);
        paintDoodle.setAlpha(opacity);
    }

    public void setSize(int sizeIn) {
        size = sizeIn < 5 ? 5 : sizeIn;
        if (quad) {
            paths.put(path, paintDoodle);
            paths.put(p2, paintDoodle);
            paths.put(p3, paintDoodle);
            paths.put(p4, paintDoodle);
            p2 = new Path();
            p3 = new Path();
            p4 = new Path();
        } else {
            paths.put(path, paintDoodle);
        }
        path = new Path();
        paintDoodle = new Paint();
        paintDoodle.setAntiAlias(true);
        paintDoodle.setStyle(Paint.Style.STROKE);
        paintDoodle.setColor(color);
        paintDoodle.setStrokeWidth(size);
        paintDoodle.setAlpha(opacity);
    }

    public void setQuad() {
        if (quad) {
            paths.put(path, paintDoodle);
            paths.put(p2, paintDoodle);
            paths.put(p3, paintDoodle);
            paths.put(p4, paintDoodle);
            path = new Path();
            paintDoodle = new Paint();
            paintDoodle.setAntiAlias(true);
            paintDoodle.setStyle(Paint.Style.STROKE);
            paintDoodle.setColor(color);
            paintDoodle.setStrokeWidth(size);
            paintDoodle.setAlpha(opacity);
            quad = false;
        } else {
            paths.put(path, paintDoodle);
            paintDoodle = new Paint();
            paintDoodle.setAntiAlias(true);
            paintDoodle.setStyle(Paint.Style.STROKE);
            paintDoodle.setColor(color);
            paintDoodle.setStrokeWidth(size);
            paintDoodle.setAlpha(opacity);
            path = new Path();
            p2 = new Path();
            p3 = new Path();
            p4 = new Path();
            quad = true;
        }
    }
}
