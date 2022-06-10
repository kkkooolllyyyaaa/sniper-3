package com.tsypk.sniper3.graph;

import com.tsypk.sniper3.graph.shapes.*;
import org.junit.Before;
import org.junit.Test;

import static com.tsypk.sniper3.graph.shapes.Consts.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GraphTest {
    private Graph graph;

    @Before
    public void setUp() {
        Shape topLeft = new Triangle(Radius.HALF_R, Radius.HALF_R);
        Shape botRight = new Rectangle(Radius.HALF_R, Radius.R);
        Shape topRight = new Circle(Radius.HALF_R);
        graph = new Graph(topLeft, topRight, botRight, null);
    }

    @Test
    public void isHit_topLeft_true() {
        double radius = RAD_5;
        double x = -RAD_1;
        double y = RAD_1;

        boolean result = graph.isHit(radius, x, y);

        assertTrue(result);
    }

    @Test
    public void isHit_topLeft_false() {
        double radius = RAD_5;
        double x = -HALF_RAD_3;
        double y = HALF_RAD_3;

        boolean result = graph.isHit(radius, x, y);

        assertFalse(result);
    }

    @Test
    public void isHit_topRight_true() {
        double radius = RAD_4;
        double x = HALF_RAD_3;
        double y = RAD_1;

        boolean result = graph.isHit(radius, x, y);

        assertTrue(result);
    }

    @Test
    public void isHit_topRight_false() {
        double radius = RAD_4;
        double x = RAD_2;
        double y = RAD_2;

        boolean result = graph.isHit(radius, x, y);

        assertFalse(result);
    }

    @Test
    public void isHit_botRight_true() {
        double radius = RAD_4;
        double x = RAD_1;
        double y = -RAD_2;

        boolean result = graph.isHit(radius, x, y);

        assertTrue(result);
    }

    @Test
    public void isHit_botRight_false() {
        double radius = RAD_4;
        double x = HALF_RAD_4 + DELTA;
        double y = -(RAD_4 + DELTA);

        boolean result = graph.isHit(radius, x, y);

        assertFalse(result);
    }

    @Test
    public void isHit_botLeft_false() {
        double radius = RAD_1;
        double x = -(ZERO + DELTA);
        double y = -(ZERO + DELTA);

        boolean result = graph.isHit(radius, x, y);

        assertFalse(result);
    }
}