package com.tsypk.sniper3.mBeans;



public class HitRatio implements HitRatioMBean {
    private double ratio = 0;
    private double hit = 0;
    private double total = 0;

    public void doCalc(boolean isHit) {
        total++;
        if (isHit)
            hit++;
        ratio = (hit / total) * 100;
    }

    @Override
    public double getRatio() {
        return ratio;
    }

    public void setHit(double hit) {
        this.hit = hit;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}
