package com.dz.elen.homeworks;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ClockView extends View {


    public ClockView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);


        Paint paintRound = new Paint();
        paintRound.setAntiAlias(true);
        paintRound.setColor(Color.RED);

        canvas.drawCircle(getWidth()/2,getHeight()/2,300, paintRound);
        canvas.save();

        paintRound.setColor(Color.WHITE);
        paintRound.setStrokeWidth(1);

        Paint paintText = new Paint();
        paintText.setTextSize(56);
        paintText.setColor(Color.WHITE);
        String text = "";

        for (int i = 0; i<12; i++ ){
            canvas.drawLine(getWidth()/2,getHeight()/2-260, getWidth()/2,getHeight()/2-295,paintRound);

            switch (i){
                case 0: text = "12"; break;
                case 3: text="3"; break;
                case 6:text = "6"; break;
                case 9: text = "9"; break;
                default: text="";
            }
            canvas.drawText(text, getWidth()/2-20,getHeight()/2-200, paintText);
            canvas.rotate(30,getWidth()/2, getHeight()/2);
        }


        float hourDegrees = 0;
        float minDegrees = 0;


        Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+4"));
        int hour = c.get(Calendar.HOUR_OF_DAY); //24
        int min = c.get(Calendar.MINUTE); //60


        /*Calendar rightNow = Calendar.getInstance();
        rightNow.setTimeZone(TimeZone.getTimeZone("GMT+4"));
        double hour = rightNow.get(Calendar.HOUR_OF_DAY);
        double minute = rightNow.get(Calendar.MINUTE);*/


        hourDegrees = (float) (360.0/24.0*(hour));
        minDegrees = (float) (360.0/60.0*min);

        System.out.print(hourDegrees);
        paintRound.setStrokeWidth(5);

        canvas.rotate((float) hourDegrees, getWidth()/2, getHeight()/2);
        canvas.drawLine(getWidth()/2,getHeight()/2, getWidth()/2,getHeight()/2-100,paintRound);

        canvas.rotate((float) minDegrees-30, getWidth()/2, getHeight()/2);
        canvas.drawLine(getWidth()/2,getHeight()/2, getWidth()/2,getHeight()/2-200,paintRound);

    }
}
