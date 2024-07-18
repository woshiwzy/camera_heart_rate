package com.example.android.heartrate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

public class HoleView extends View {
    private Paint paint;
    private Path path;

    public HoleView(Context context) {
        super(context);
        init();
    }

    public HoleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HoleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(0xFF000000); // 设置背景颜色为黑色
        paint.setAntiAlias(true);

        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width, height) / 4; // 圆的半径

        // 创建一个中间透明的圆洞
        path.reset();

        path.addCircle(width / 2, height / 2, radius, Path.Direction.CW);

        // 使用PorterDuffXfermode来实现透明效果
        int saveCount = canvas.saveLayer(0, 0, width, height, null, Canvas.ALL_SAVE_FLAG);

        canvas.drawColor(0xFF000000); // 绘制背景颜色

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPath(path, paint);//xfermode 清除

        paint.setXfermode(null);
        canvas.restoreToCount(saveCount);

//        CLEAR：清除所有像素。
//        SRC：只显示源图像。
//        DST：只显示目标图像。
//        SRC_OVER：源图像覆盖在目标图像上。
//        DST_OVER：目标图像覆盖在源图像上。
//        SRC_IN：只显示源图像与目标图像重叠的部分。
//        DST_IN：只显示目标图像与源图像重叠的部分。
//        SRC_OUT：只显示源图像与目标图像不重叠的部分。
//        DST_OUT：只显示目标图像与源图像不重叠的部分。
//        SRC_ATOP：源图像与目标图像重叠的部分显示源图像，不重叠的部分显示目标图像。
//        DST_ATOP：目标图像与源图像重叠的部分显示目标图像，不重叠的部分显示源图像。
//        XOR：源图像与目标图像重叠的部分被清除。

    }
}
