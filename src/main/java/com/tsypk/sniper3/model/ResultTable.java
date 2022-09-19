package com.tsypk.sniper3.model;

import com.tsypk.sniper3.database.PointsDAO;
import com.tsypk.sniper3.database.SniperPointsDAO;
import com.tsypk.sniper3.graph.Graph;
import com.tsypk.sniper3.graph.shapes.*;
import com.tsypk.sniper3.mBeans.MBeanServerManager;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author tsypk on 11.11.2021 04:26
 * @project sniper-3
 */

@ManagedBean(eager = true)
@ApplicationScoped
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ResultTable {
    private ArrayList<Point> points;
    private PointsDAO pointsDAO;
    private Validator validator;
    private Graph graph;

    @Inject
    private Point point;

    public ResultTable() {
        pointsDAO = new SniperPointsDAO();
        initPoints();
        initGraph();
        initValidator();
    }

    public void add() {
        if (!checkFields()) {

            return;
        }

        Point handledPoint = getHandledPoint();
        Set<ConstraintViolation<Point>> violations = validator.validate(point);
        if (violations.isEmpty() && pointsDAO.addPoint(handledPoint)) {
            MBeanServerManager.getPcBean().increment(handledPoint.isResult());
            MBeanServerManager.getAdBean().doDeterminant(handledPoint);
            MBeanServerManager.getHrBean().doCalc(handledPoint.isResult());
            points.add(handledPoint);
        }
    }

    public void clearTable() {
        pointsDAO.clear();
        points.clear();
        MBeanServerManager.getPcBean().setMissedPointsCount(0);
        MBeanServerManager.getPcBean().setTotalPointsCount(0);
        MBeanServerManager.getHrBean().setHit(0);
        MBeanServerManager.getHrBean().setTotal(0);
        MBeanServerManager.getHrBean().setRatio(0);
    }

    private Point getHandledPoint() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
        Date date = new Date(System.currentTimeMillis());
        return Point.builder()
                .x(point.getX())
                .y(point.getY())
                .radius(point.getRadius())
                .result(graph.isHit(point))
                .time((dateFormat.format(date))).build();
    }

    private boolean checkFields() {
        return point != null && point.getX() != null && point.getY() != null && point.getRadius() != null;
    }

    private void initGraph() {
        Shape topLeft = new Triangle(Radius.HALF_R, Radius.HALF_R);
        Shape botRight = new Rectangle(Radius.R, Radius.R);
        Shape topRight = new Circle(Radius.HALF_R);
        graph = new Graph(topLeft, topRight, botRight, null);
    }

    private void initValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    private void initPoints() {
        List<Point> current = pointsDAO.getAll();
        points = (ArrayList<Point>) current;
    }
}
