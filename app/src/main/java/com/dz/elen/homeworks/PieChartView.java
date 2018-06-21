package com.dz.elen.homeworks;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class PieChartView extends View {

    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    float[] value_degree;
    int[] COLORS={Color.BLUE,Color.GREEN,Color.RED,Color.CYAN,Color.RED};



    public PieChartView(Context context, float[] values) {
        super(context);

        float total = 0;
        for(float i: values)
            total+=i;

        value_degree=new float[values.length];
        for(int i=0;i<values.length;i++)
        {
            value_degree[i]=360*(values[i]/total);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        RectF rectF = new RectF();
        rectF.left = getWidth()*0.10f;
        rectF.top = getHeight()*0.25f;
        rectF.right = getWidth() - rectF.left;
        rectF.bottom = getHeight() - getHeight()*0.25f;


        int temp=0;
        for (int i = 0; i < value_degree.length; i++) {

                paint.setColor(COLORS[i]);
                canvas.drawArc(rectF, temp, value_degree[i], true, paint);
                temp += (int) value_degree[i];
        }

    }
}
