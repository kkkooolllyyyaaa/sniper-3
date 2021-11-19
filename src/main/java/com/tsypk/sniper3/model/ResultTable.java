package com.tsypk.sniper3.model;

import com.tsypk.sniper3.database.PointsDAO;
import com.tsypk.sniper3.database.SniperPointsDAO;
import com.tsypk.sniper3.utils.PointService;
import com.tsypk.sniper3.utils.PointValidator;
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
    private PointsDAO pointsDAO;
    @Inject
    private Point point;
    private Point svgPoint;
    private String curR;

    public ResultTable() {
        pointsDAO = new SniperPointsDAO();
        points = pointsDAO.getAll();
    }

    public void clearTable() {
        pointsDAO.clear();
        points = new ArrayList<>();
    }

    public void add() {
        if (checkPointFields()) {
            curR = point.getRadius().toString();
            Point handledPoint = getHandledPoint();
            if (pointsDAO.addPoint(handledPoint)) {
                points.add(handledPoint);
            }
        }
    }

    private Point getHandledPoint() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
        Point curPoint = Point.builder()
                .x(point.getX())
                .y(point.getY())
                .radius(point.getRadius())
                .time((dateFormat.format(new Date(System.currentTimeMillis())))).build();
        PointService service = new PointService(curPoint);
        service.handle();
        PointValidator.validate(curPoint);
        return curPoint;
    }

    private boolean checkPointFields() {
        return point != null && this.point.getX() != null &&
                this.point.getY() != null &&
                this.point.getRadius() != null;
    }

    public String getCurR() {
        try {
            if (curR != null) {
                Double.parseDouble(curR);
                return curR;
            } else {
                return "R";
            }
        } catch (NumberFormatException e) {
            return "R";
        }
    }
}
