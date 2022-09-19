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
    private static PointsCounter pcBean;
    private static AreaDeterminant adBean;

    public MBeanServerManager() {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        pcBean = new PointsCounter();
        adBean = new AreaDeterminant();
        try {
            ObjectName pcName = new ObjectName("web:type=PointsCounter");
            server.registerMBean(pcBean, pcName);
            ObjectName adName = new ObjectName("web:type=AreaDeterminant");
            server.registerMBean(adBean, adName);
        } catch (InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException | MalformedObjectNameException e) {
            System.out.println("Something wrong");
        }
    }

    public static PointsCounter getPcBean() {
        return pcBean;
    }

    public static AreaDeterminant getAdBean() {
        return adBean;
    }
}
