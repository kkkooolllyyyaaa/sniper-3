package com.tsypk.sniper3.model;

import lombok.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author tsypk on 11.11.2021 04:05
 * @project sniper-3
 */
@Named
@RequestScoped
@Entity
@Table(name = "points", indexes = {
        @Index(name = "idx_point_id", columnList = "id")
})

@NoArgsConstructor
@AllArgsConstructor
@Builder

@Getter
@Setter
@ToString
public class Point implements Serializable {
    @Id
    @SequenceGenerator(name = "sequenceGenerator", sequenceName = "id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    private Integer id;
    @Column(nullable = false, name = "x")
    @Min(-5)
    @Max(3)
    private Double x;
    @Column(nullable = false, name = "y")
    @Min(-3)
    @Max(5)
    private Double y;
    @Column(nullable = false, name = "radius")
    @Min(1)
    @Max(5)
    private Double radius;
    @Column(nullable = false, name = "result")
    private boolean result;
    @Column(nullable = false, name = "time")
    @Size(min = 19, max = 19)
    private String time;

    public void initRadius(double radius) {
        this.radius = radius;
    }
}
