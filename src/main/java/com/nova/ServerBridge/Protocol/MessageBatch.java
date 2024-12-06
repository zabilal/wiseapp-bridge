package com.nova.ServerBridge.Protocol;

import com.nova.ServerBridge.Configuration;

import java.util.ArrayList;

/**
 * Created by Zakariyya Raji on 2017-12-19-12-30.
 *
 * Uses batching to send message history.
 */
public class MessageBatch {
    private Header header;
    private ArrayList<Message> list = new ArrayList<>();

    public MessageBatch() {
        this.header = new Header("message");
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public ArrayList<Message> getList() {
        return list;
    }

    public void setList(ArrayList<Message> list) {
        this.list = list;
    }

    public void add(Message message) {
        list.add(message);
    }

    public boolean ready() {
        return (list.size() >= Configuration.PERSISTENCE_MESSAGE_BATCH);
    }

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
