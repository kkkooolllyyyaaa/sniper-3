package com.tsypk.sniper3.graph.shapes;

/**
 * @author tsypk on 07.02.2022 10:02
 * @project sniper
 */
public class Triangle extends Shape {
    private final double k;
    private final double bMulti;

    public Triangle(Radius xRad, Radius yRad) {
        if (xRad.equals(yRad))
            k = 1.0d;
        else if (xRad == Radius.R)
            k = 1.0d / 2.0d;
        else
            k = 2.0d;

        if (yRad == Radius.R)
            bMulti = 1.0d;
        else
            bMulti = 1.0d / 2.0d;
    }

    @Override
    public boolean isHit(double radius, double x, double y) {
        double b = bMulti * radius;
        y = Math.abs(y);
        x = Math.abs(x);
        return y <= (-k * x + b);
    }
}
