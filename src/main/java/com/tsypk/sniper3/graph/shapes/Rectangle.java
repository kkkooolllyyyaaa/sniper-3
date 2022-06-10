package com.tsypk.sniper3.graph.shapes;

/**
 * @author tsypk on 07.02.2022 10:08
 * @project sniper
 */
public class Rectangle extends Shape {
    private final double xMultiplier;
    private final double yMultiplier;

    public Rectangle(Radius xRad, Radius yRad) {
        if (xRad == Radius.HALF_R)
            xMultiplier = 2.0d;
        else
            xMultiplier = 1.0d;
        if (yRad == Radius.HALF_R)
            yMultiplier = 2.0d;
        else
            yMultiplier = 1.0d;
    }

    @Override
    public boolean isHit(double radius, double x, double y) {
        x = Math.abs(x);
        y = Math.abs(y);
        return (x * xMultiplier) <= radius && (y * yMultiplier) <= radius;
    }
}
