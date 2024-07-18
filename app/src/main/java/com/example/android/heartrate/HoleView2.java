package com.example.android.heartrate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

public class HoleView2 extends View {
    private Paint paint;
    private Bitmap bitmap;
    private Canvas bitmapCanvas;

    public HoleView2(Context context) {
        super(context);
        init();
    }

    public HoleView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HoleView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw || h != oldh) {
            bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            bitmapCanvas = new Canvas(bitmap);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width, height) / 2; // 圆的半径

        // 创建一个中间透明的圆洞
        bitmapCanvas.drawColor(0xFF000000, PorterDuff.Mode.CLEAR);
        bitmapCanvas.drawColor(0xFFFFFFFF); // 绘制背景颜色

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        bitmapCanvas.drawCircle(width / 2, height / 2, radius, paint);
        paint.setXfermode(null);

        // 绘制位图
        canvas.drawBitmap(bitmap, 0, 0, null);
    }
}

