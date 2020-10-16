package com.example.plotapp;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
//绘制坐标轴
public class Axis {

    //逻辑范围
    private int nMinX;
    private int nMaxX;
    private int nMinY;
    private int nMaxY;

    //物理范围
    private Rect mRect;

    public Axis(Rect rect) {
        nMinX = -10;
        nMaxX = 10;
        nMinY = -10;
        nMaxY = 10;

        mRect = rect;
    }

    public int getnMaxX() {
        return nMaxX;
    }

    public void setnMaxX(int nMaxX) {
        this.nMaxX = nMaxX;
    }

    public int getnMaxY() {
        return nMaxY;
    }

    public void setnMaxY(int nMaxY) {
        this.nMaxY = nMaxY;
    }

    public int getnMinX() {
        return nMinX;
    }

    public void setnMinX(int nMinX) {
        this.nMinX = nMinX;
    }

    public int getnMinY() {
        return nMinY;
    }

    public void setnMinY(int nMinY) {
        this.nMinY = nMinY;
    }


    //将逻辑坐标转换为物理坐标
    public Point convertLP2DP(Point point) {
        Point pointNew = new Point();
        pointNew.x = convertXLP2DP(point.x);
        pointNew.y = convertYLP2DP(point.y);

        return pointNew;
    }

    //将逻辑坐标转换为物理坐标
    public int convertXLP2DP(double x) {
        return mRect.left + (int) (mRect.width() / (double) (nMaxX - nMinX) * (x - nMinX));
    }

    //将逻辑坐标转换为物理坐标
    public int convertYLP2DP(double y) {
        return mRect.bottom
                - (int) (mRect.height() / (double) (nMaxY - nMinY) * (y - nMinX));
    }


    //绘制坐标轴
    public void draw(Canvas canvas) {
        //画笔
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        double nX=(double)(nMaxX-nMinX)/20;
        double nY=(double)(nMaxY-nMinY)/20;

        //绘制坐标轴
        canvas.drawLine(convertXLP2DP(nMinX), convertYLP2DP(0), convertXLP2DP(nMaxX), convertYLP2DP(0), paint);//x轴
        canvas.drawLine(convertXLP2DP(0), convertYLP2DP(nMaxY), convertXLP2DP(0), convertYLP2DP(nMinY), paint);//y轴

        //绘制坐标轴上的坐标（数字）
        //paint.setStrokeWidth(0);//设置空心的字体
        paint.setTextSize(40);
        canvas.drawText("O", convertXLP2DP(nX), convertYLP2DP(-nY), paint);//原点
        canvas.drawText(nMinX+"", convertXLP2DP(nMinX+nX), convertYLP2DP(-nY), paint);//x最小
        canvas.drawText(nMaxX+"",convertXLP2DP(nMaxX-nX), convertYLP2DP(-nY),paint);//x最大
        canvas.drawText(nMinX/2+"", convertXLP2DP((nMinX+nX)/2), convertYLP2DP(-nY), paint);//x负半轴中间
        canvas.drawText(nMaxX/2+"",convertXLP2DP((nMaxX-nX)/2), convertYLP2DP(-nY),paint);//x正半轴中间
        canvas.drawText(nMinY+"",convertXLP2DP(-nX), convertYLP2DP(nMinY+nY),paint);//y最小
        canvas.drawText(nMaxY+"",convertXLP2DP(-nX), convertYLP2DP(nMaxY-nY),paint);//y最大
        canvas.drawText(nMinY/2+"",convertXLP2DP(-nX), convertYLP2DP((nMinY+nY)/2),paint);//y轴负半轴中间
        canvas.drawText(nMaxY/2+"",convertXLP2DP(-nX), convertYLP2DP((nMaxY-nY)/2),paint);//y轴正半轴中间

    }
}
