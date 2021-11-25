package com.tsypk.sniper3.utils;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.util.Objects;
import java.util.Properties;

/**
 * @author tsypk on 24.11.2021 02:39
 * @project sniper-3
 */
public class PortForwarder {
    private static String sshUser;
    private static String sshPassword;
    private static String sshHost;
    private static int sshPort;

    private static String remoteHost;
    private static int remotePort;
    private static int localPort;

    public static void connect() {
        initFields();
        doSshTunnel();
    }

    private static boolean doSshTunnel() {
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(sshUser, sshHost, sshPort);
            session.setPassword(sshPassword);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            session.setPortForwardingL(localPort, remoteHost, remotePort);
            return true;
        } catch (JSchException unexpected) {
            unexpected.printStackTrace();
            return false;
        }
    }

    private static void initFields() {
        sshUser = PropertyManager.getProperty("sshUser");
        sshPassword = PropertyManager.getProperty("sshPassword");
        sshHost = PropertyManager.getProperty("sshHost");
        sshPort = Integer.parseInt(Objects.requireNonNull(PropertyManager.getProperty("sshPortNumber")));
        remoteHost = PropertyManager.getProperty("remoteHost");
        remotePort = Integer.parseInt(Objects.requireNonNull(PropertyManager.getProperty("remotePort")));
        localPort = Integer.parseInt(Objects.requireNonNull(PropertyManager.getProperty("localPort")));
    }
}