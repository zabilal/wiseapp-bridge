package com.nova.ServerBridge.Protocol;

/**
 * Created by Zakariyya Raji on 2017-12-19-12-17.
 *
 * Transfer object for user events.
 **/
public class UserEvent {
    public final static String ACTION = "user.event";
    private Boolean join;
    private String room;
    private String username;
    private Header header;

    public UserEvent() {
    }


    public Boolean getJoin() {
        return join;
    }

    public void setJoin(Boolean join) {
        this.join = join;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }
}
