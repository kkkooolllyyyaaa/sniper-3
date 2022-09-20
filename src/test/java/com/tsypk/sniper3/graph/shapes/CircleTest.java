package com.tsypk.sniper3.graph.shapes;

import org.junit.Test;

import static com.tsypk.sniper3.graph.shapes.Consts.*;
import static org.junit.Assert.*;

public class CircleTest {
    private Shape shape;

    @Test
    public void isHit_vertex1_true() {
        shape = new Circle(Radius.HALF_R);
        double radius = Consts.RAD_5;
        double x = Consts.HALF_RAD_5;
        double y = Consts.ZERO;

        boolean result = shape.isHit(radius, x, y);

        assertTrue(result);
    }

    @Test
    public void isHit_vertex2_true() {
        shape = new Circle(Radius.R);
        double radius = RAD_4;
        double x = ZERO;
        double y = RAD_4;

        boolean result = shape.isHit(radius, x, y);

        assertTrue(result);
    }

    @Test
    public void isHit_vertex1_false() {
        shape = new Circle(Radius.HALF_R);
        double radius = RAD_3;
        double x = HALF_RAD_3 + DELTA;
        double y = ZERO - DELTA;

        boolean result = shape.isHit(radius, x, y);

        assertFalse(result);
    }

    @Test
    public void isHit_vertex2_false() {
        shape = new Circle(Radius.R);
        double radius = RAD_2;
        double x = ZERO - DELTA;
        double y = RAD_2 + DELTA;

        boolean result = shape.isHit(radius, x, y);

        assertFalse(result);
    }

    @Test
    public void isHit_mid1_true() {
        shape = new Circle(Radius.R);
        double radius = RAD_1;
        double x = HALF_RAD_1;
        double y = HALF_RAD_1;

        boolean result = shape.isHit(radius, x, y);

        assertTrue(result);
    }

    @Test
    public void isHit_mid2_true() {
        shape = new Circle(Radius.HALF_R);
        double radius = RAD_5;
        double x = HALF_RAD_5 / 2.0d;
        double y = HALF_RAD_5 / 2.0d;

        boolean result = shape.isHit(radius, x, y);

        assertTrue(result);
    }

    @Test
    public void isHit_arc_true() {
        shape = new Circle(Radius.R);
        double radius = RAD_4;
        double x = SQRT2 * HALF_RAD_4;
        double y = SQRT2 * HALF_RAD_4;

        boolean result = shape.isHit(radius, x, y);

        assertTrue(result);
    }

    @Test
    public void isHit_arc_false() {
        shape = new Circle(Radius.R);
        double radius = RAD_3;
        double x = SQRT2 * (HALF_RAD_3 + DELTA);
        double y = SQRT2 * (HALF_RAD_3 + DELTA);

        boolean result = shape.isHit(radius, x, y);

        assertFalse(result);
    }

    @Test
    public void isHit_outVertex_false() {
        shape = new Circle(Radius.R);
        double radius = RAD_2;
        double x = RAD_2;
        double y = RAD_2;

        boolean result = shape.isHit(radius, x, y);

        assertFalse(result);
    }
}