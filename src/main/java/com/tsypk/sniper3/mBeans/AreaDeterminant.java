package com.tsypk.sniper3.mBeans;

import com.tsypk.sniper3.model.Point;

import javax.management.NotificationBroadcasterSupport;

public class AreaDeterminant extends NotificationBroadcasterSupport implements AreaDeterminantMBean {

    private double squareArea = 0;
    private double triangleArea = 0;
    private double arcArea = 0;

    public void doDeterminant(Point point) {
        squareArea = Math.pow(point.getRadius(), 2.0D);
        arcArea = (Math.pow(point.getRadius() / 2.0D, 2) * Math.PI) / 4.0D;
        triangleArea = 0.5 * Math.pow(point.getRadius() / 2.0D, 2);
    }

    @Override
    public double getArea() {
        return squareArea + triangleArea + arcArea;
    }

    @Override
    public double getSquareArea() {
        return squareArea;
    }

    @Override
    public double getTriangleArea() {
        return triangleArea;
    }

    @Override
    public double getArcArea() {
        return arcArea;
    }
}
