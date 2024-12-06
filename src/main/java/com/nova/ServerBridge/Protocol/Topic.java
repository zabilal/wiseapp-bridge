package com.nova.ServerBridge.Protocol;

/**
 * Created by Zakariyya Raji on 2017-12-19-12-16.
 * <p>
 * Transfer object for changing the topic and notifying topic changes.
 */
public class Topic {
    public static final String ACTION = "topic";
    private Header header;
    private String topic;
    private String room;

    public Topic() {
        this.header = new Header(ACTION);
    }

    public Topic(String room, String topic) {
        this();
        this.room = room;
        this.topic = topic;
    }


    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
