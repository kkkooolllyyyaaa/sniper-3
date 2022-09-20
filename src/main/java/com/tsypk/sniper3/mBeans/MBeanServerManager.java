package com.tsypk.sniper3.mBeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * @author tsypk on 17.09.2022 19:05
 * @project web-lab-3
 */
@ManagedBean(eager = true)
@ApplicationScoped

public class MBeanServerManager {
    private static final PointsCounter pcBean = new PointsCounter();
    private static final AreaDeterminant adBean = new AreaDeterminant();
    private static final HitRatio hrBean = new HitRatio();

    public MBeanServerManager() {
        try {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            ObjectName pcName = new ObjectName("web:type=PointsCounter");
            server.registerMBean(pcBean, pcName);
            ObjectName adName = new ObjectName("web:type=AreaDeterminant");
            server.registerMBean(adBean, adName);
            ObjectName hrName = new ObjectName("web:type=HitRatio");
            server.registerMBean(hrBean, hrName);
        } catch (InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException | MalformedObjectNameException e) {
            System.out.println("Something wrong " + e);
        }
    }

    public static PointsCounter getPcBean() {
        return pcBean;
    }

    public static AreaDeterminant getAdBean() {
        return adBean;
    }

    public static HitRatio getHrBean() {
        return hrBean;
    }
}
