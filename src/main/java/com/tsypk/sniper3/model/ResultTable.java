package com.tsypk.sniper3.model;

import com.tsypk.sniper3.database.PointsDAO;
import com.tsypk.sniper3.database.SniperPointsDAO;
import com.tsypk.sniper3.utils.PointService;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

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
    private Validator validator;

    public ResultTable() {
        pointsDAO = new SniperPointsDAO();
        points = (ArrayList<Point>) pointsDAO.getAll();
        initValidator();
    }

    public void clearTable() {
        pointsDAO.clear();
        points = new ArrayList<>();
    }

    public void add() {
        if (checkFields()) {
            Point handledPoint = getHandledPoint();
            Set<ConstraintViolation<Point>> violations = validator.validate(point);
            if (violations.size() == 0) {
                if (pointsDAO.addPoint(handledPoint))
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
        return curPoint;
    }

    private void initValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    private boolean checkFields() {
        return point != null && point.getX() != null && point.getY() != null && point.getRadius() != null;
    }
}
