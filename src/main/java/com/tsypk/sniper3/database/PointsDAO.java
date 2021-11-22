package com.tsypk.sniper3.database;

import com.tsypk.sniper3.model.Point;

import java.util.List;

/**
 * @author tsypk on 11.11.2021 04:27
 * @project sniper-3
 */
public interface PointsDAO {
    boolean addPoint(Point point);

    List<Point> getAll();

    List<Point> head(int count);

    void clear();

}
