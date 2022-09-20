package com.tsypk.sniper3.mBeans;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

/**
 * @author tsypk on 17.09.2022 18:09
 * @project web-lab-3
 */
public class PointsCounter extends NotificationBroadcasterSupport implements PointsCounterMBean {
    private int totalPointsCount = 0;
    private int missedPointsCount = 0;
    private static int currentCount = 0;

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[]{
                AttributeChangeNotification.ATTRIBUTE_CHANGE
        };

        String name = AttributeChangeNotification.class.getName();
        String description = "An attribute of this MBean has changed";
        MBeanNotificationInfo info =
                new MBeanNotificationInfo(types, name, description);
        return new MBeanNotificationInfo[]{info};
    }

    public void increment(boolean isHit) {
        totalPointsCount++;
        if (!isHit) {
            missedPointsCount++;
            currentCount++;
        } else {
            currentCount = 0;
        }
        if (currentCount >= 4) {
            Notification n = new AttributeChangeNotification(
                    this,
                    currentCount,
                    System.currentTimeMillis(),
                    "The number of misses in a row is ge 4",
                    "Misses in a row",
                    "int",
                    currentCount - 1,
                    currentCount
            );

            sendNotification(n);
            currentCount = 0;
        }
    }

    @Override
    public int getTotalPointsCount() {
        return totalPointsCount;
    }

    @Override
    public int getMissedPointsCount() {
        return missedPointsCount;
    }

    public void setTotalPointsCount(int totalPointsCount) {
        this.totalPointsCount = totalPointsCount;
    }

    public void setMissedPointsCount(int missedPointsCount) {
        this.missedPointsCount = missedPointsCount;
    }
}
