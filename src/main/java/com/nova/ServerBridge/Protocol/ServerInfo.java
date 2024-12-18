package com.nova.ServerBridge.Protocol;

import com.nova.ServerBridge.Model.Server;

/**
 * Created by Zakariyya Raji on 2017-12-19-12-16.
 * <p>
 * A host running the room protocol.
 */
public class ServerInfo {
    private String ip;
    private String name;
    private Integer port;
    private Boolean full = false;

    public ServerInfo(Server server) {
        this.ip = server.getIp();
        this.name = server.getName();
        this.port = server.getPort();
        this.full = server.getFull();
    }

    public Boolean getFull() {
        return full;
    }

    public void setFull(Boolean full) {
        this.full = full;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
