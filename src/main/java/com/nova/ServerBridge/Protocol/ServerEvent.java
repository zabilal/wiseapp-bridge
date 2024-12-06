package com.nova.ServerBridge.Protocol;

import com.nova.ServerBridge.Model.Server;

/**
 * Created by Zakariyya Raji on 2017-12-19-12-18.
 * <p>
 * Sent from the connector, indicating a chatservers state.
 */
public class ServerEvent {
    public static final String ACTION = "registry.server";
    private String name;
    private String ip;
    private Integer port;
    private Header header;
    private ServerStatus status;

    public ServerEvent() {
        this(null);
    }


    public ServerEvent(String name, ServerStatus status) {
        this(status);
        this.name = name;
    }

    public ServerEvent(Server server, ServerStatus status) {
        this(status);
        this.ip = server.getIp();
        this.name = server.getName();
        this.port = server.getPort();
    }

    public ServerEvent(ServerStatus status) {
        this.status = status;
        this.header = new Header(ACTION);
    }

    public String getName() {
        return name;
    }

    public ServerEvent setName(String name) {
        this.name = name;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public ServerEvent setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public Integer getPort() {
        return port;
    }

    public ServerEvent setPort(Integer port) {
        this.port = port;
        return this;
    }

    public Header getHeader() {
        return header;
    }

    public ServerEvent setHeader(Header header) {
        this.header = header;
        return this;
    }

    public ServerStatus getStatus() {
        return status;
    }

    public ServerEvent setStatus(ServerStatus status) {
        this.status = status;
        return this;
    }

    public enum ServerStatus {
        UP, DOWN, FULL, READY
    }

    ;

}
