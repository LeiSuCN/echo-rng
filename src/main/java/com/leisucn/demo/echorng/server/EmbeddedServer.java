package com.leisucn.demo.echorng.server;

import org.jboss.resteasy.plugins.server.netty.NettyContainer;
import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmbeddedServer {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private STATUS status;

    private NettyJaxrsServer server;

    private ResteasyDeployment deployment;

    public void start(int port) {

        System.setProperty("org.jboss.resteasy.port", String.valueOf(port));

        try {
            deployment = NettyContainer.start();
        } catch (Exception e) {
            e.printStackTrace();
            this.status = STATUS.DOWN;
        }

        if (NettyContainer.netty != null) {
            this.server = NettyContainer.netty;
            this.status = STATUS.UP;
        } else {
            this.status = STATUS.DOWN;
        }
    }

    public STATUS getStatus() {
        return status;
    }

    public NettyJaxrsServer getServer() {
        return server;
    }

    public ResteasyDeployment getDeployment() {
        return deployment;
    }

    public static enum STATUS {
        UP, DOWN
    }
}
