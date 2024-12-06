package com.nova.ServerBridge.Protocol;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zakariyya Raji on 2017-12-19-12-16.
 * <p>
 * Transfer object for requesting/returning a list of the currently connected servers.
 */
public class ServerList {
    public static final String ACTION = "server.list";
    private Header header;
    private List<ServerInfo> list;

    public ServerList() {
    }

    public ServerList(String actor) {
        this.header = new Header(ACTION, actor);
    }

    public ServerList(ArrayList<ServerInfo> list) {
        this("");
        this.list = list;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public List<ServerInfo> getList() {
        return list;
    }

    public void setList(List<ServerInfo> list) {
        this.list = list;
    }
}
