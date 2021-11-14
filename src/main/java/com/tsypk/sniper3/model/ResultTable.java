package com.tsypk.sniper3.model;

import com.tsypk.sniper3.utils.PointService;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author tsypk on 11.11.2021 04:26
 * @project sniper-3
 */

@Named
@ApplicationScoped
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ResultTable {
    private ArrayList<Point> points;
    @Inject
    private Point point;
    private double curR;

    public ResultTable() {
        points = new ArrayList<>();
    }

    public void clearTable() {
        points = new ArrayList<>();
    }

    public void add() {
        Point handledPoint = getHandledPoint();
        if (points.size() == 5)
            points.remove(0);
        points.add(handledPoint);
    }

    private Point getHandledPoint() {
        Point curPoint = new Point();
        curPoint.setRadius(point.getRadius());
        curPoint.setX(point.getX());
        curPoint.setY(point.getY());
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
        curPoint.setTime((dateFormat.format(new Date(System.currentTimeMillis()))));
        PointService service = new PointService(curPoint);
        service.handle();
        return curPoint;
    }
}
