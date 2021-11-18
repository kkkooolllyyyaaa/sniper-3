package com.tsypk.sniper3.utils;

import com.tsypk.sniper3.model.Point;

/**
 * @author tsypk on 11.11.2021 04:07
 * @project sniper-3
 */
public class PointService {
    private final Point point;
    private final double x;
    private final double y;
    private final double radius;

    public PointService(Point point) {
        this.point = point;
        x = point.getX();
        y = point.getY();
        radius = point.getRadius();
    }

    public void handle() {
        point.setResult(isInArea());
    }

    private boolean isInArea() {
        return ((x >= 0 && y >= 0 && (x * x + y * y) <= (radius * radius / 4.0d)) ||
                (x >= 0 && y <= 0 && Math.abs(y) <= radius && Math.abs(x) <= radius) ||
                (x <= 0 && y >= 0 && y <= (x + radius / 2.0d)));
    }

    private boolean setValid() {
        return x >= -5.0d && x <= 3.0d && y >= -3.0d && y <= 5.0d && radius >= 1.0 && radius <= 5.0;
    }
}