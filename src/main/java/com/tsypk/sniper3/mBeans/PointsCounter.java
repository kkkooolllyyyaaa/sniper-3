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

    public void increment(){
        totalPointsCount++;
        System.out.println("Total points count = " + totalPointsCount);
        missedPointsCount++;
        if (totalPointsCount >= 4) {
            Notification n = new AttributeChangeNotification(this,
                    currentCount++, System.currentTimeMillis(),
                    "The number of points is ge 4", "Multiplicity", "int",
                    totalPointsCount - 1, totalPointsCount);
            sendNotification(n);
            missedPointsCount = 0;
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
}
