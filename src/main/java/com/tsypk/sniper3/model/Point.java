package com.tsypk.sniper3.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @author tsypk on 11.11.2021 04:05
 * @project sniper-3
 */
@Named
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@ApplicationScoped
@Table(name = "points", indexes = {
        @Index(name = "idx_point_id", columnList = "id")
})
public class Point implements Serializable {
    @Id
    @SequenceGenerator(name = "sequenceGenerator", sequenceName = "id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    private Integer id;
    @Column(nullable = false, name = "x")
    private double x;
    @Column(nullable = false, name = "y")
    private double y;
    @Column(nullable = false, name = "radius")
    private double radius;
    @Column(nullable = false, name = "result")
    private boolean result;
    @Column(nullable = false, name = "time")
    private String time;

    public void initRadius(double radius) {
        this.radius = radius;
    }
}
