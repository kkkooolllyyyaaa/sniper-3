package com.tsypk.sniper3.graph.shapes;

/**
 * @author tsypk on 07.02.2022 09:53
 * @project sniper
 */
public class Circle extends Shape {
    private final double multiplier;

    public Circle(Radius radius) {
        if (radius == Radius.HALF_R)
            multiplier = 1.0d / 2.0d;
        else
            multiplier = 1.0d;
    }

    @Override
    public boolean isHit(double radius, double x, double y) {
        return (x * x + y * y) <= ((radius * multiplier) * (radius * multiplier));
    }
}
