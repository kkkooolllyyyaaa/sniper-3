package com.tsypk.sniper3.mBeans;


public class HitRatio implements HitRatioMBean {

    @Override
    public double getRatio() {
        PointsCounter pcBean = MBeanServerManager.getPcBean();
        return (1 - (double) pcBean.getMissedPointsCount() / (double) pcBean.getTotalPointsCount());
    }
}
