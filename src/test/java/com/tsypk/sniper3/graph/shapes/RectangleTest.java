package com.tsypk.sniper3.graph.shapes;

import org.junit.Test;

import static com.tsypk.sniper3.graph.shapes.Consts.*;
import static org.junit.Assert.*;

public class RectangleTest {
    private Shape shape;


    @Test
    public void isHit_midRR_true() {
        shape = new Rectangle(Radius.R, Radius.R);
        double radius = RAD_5;
        double x = HALF_RAD_5;
        double y = HALF_RAD_5;

        boolean result = shape.isHit(radius, x, y);

        assertTrue(result);
    }

    @Test
    public void isHit_midRHR_true() {
        shape = new Rectangle(Radius.R, Radius.HALF_R);
        double radius = RAD_4;
        double x = HALF_RAD_4;
        double y = HALF_RAD_4 / 2.0d;

        boolean result = shape.isHit(radius, x, y);

        assertTrue(result);
    }

    @Test
    public void isHit_midHRR_true() {
        shape = new Rectangle(Radius.R, Radius.HALF_R);
        double radius = RAD_3;
        double x = HALF_RAD_3 / 2.0d;
        double y = HALF_RAD_3;

        boolean result = shape.isHit(radius, x, y);

        assertTrue(result);
    }

    @Test
    public void isHit_midHRHR_true() {
        shape = new Rectangle(Radius.R, Radius.HALF_R);
        double radius = RAD_2;
        double x = HALF_RAD_2 / 2.0d;
        double y = HALF_RAD_2;

        boolean result = shape.isHit(radius, x, y);

        assertTrue(result);
    }

    @Test
    public void isHit_vertex1_true() {
        shape = new Rectangle(Radius.R, Radius.R);
        double radius = RAD_1;
        double x = RAD_1;
        double y = RAD_1;

        boolean result = shape.isHit(radius, x, y);

        assertTrue(result);
    }

    @Test
    public void isHit_vertex2_true() {
        shape = new Rectangle(Radius.R, Radius.R);
        double radius = RAD_5;
        double x = RAD_5;
        double y = ZERO;

        boolean result = shape.isHit(radius, x, y);

        assertTrue(result);
    }

    @Test
    public void isHit_vertex3_true() {
        shape = new Rectangle(Radius.R, Radius.R);
        double radius = RAD_4;
        double x = ZERO;
        double y = ZERO;

        boolean result = shape.isHit(radius, x, y);

        assertTrue(result);
    }

    @Test
    public void isHit_vertex4_true() {
        shape = new Rectangle(Radius.R, Radius.R);
        double radius = RAD_3;
        double x = ZERO;
        double y = RAD_3;

        boolean result = shape.isHit(radius, x, y);

        assertTrue(result);
    }


    @Test
    public void isHit_outRight_false() {
        shape = new Rectangle(Radius.R, Radius.R);
        double radius = RAD_2;
        double x = HALF_RAD_2;
        double y = RAD_2 + DELTA;

        boolean result = shape.isHit(radius, x, y);

        assertFalse(result);
    }


    @Test
    public void isHit_outTop_false() {
        shape = new Rectangle(Radius.R, Radius.R);
        double radius = RAD_5;
        double x = HALF_RAD_5;
        double y = RAD_5 + DELTA;

        boolean result = shape.isHit(radius, x, y);

        assertFalse(result);
    }
}