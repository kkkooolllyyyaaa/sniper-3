package com.tsypk.sniper3.mBeans;

import com.tsypk.sniper3.model.ResultTable;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

/**
 * @author tsypk on 17.09.2022 18:09
 * @project web-lab-3
 */
@ManagedBean
public class PointsCounter {
    @Inject
    private ResultTable resultTable;

}
