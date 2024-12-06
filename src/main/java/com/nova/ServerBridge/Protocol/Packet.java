package com.nova.ServerBridge.Protocol;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Zakariyya Raji on 2017-12-18.
 *
 * Generic container for partial unpacking to inspect the action/message type.
 */


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Packet {
    private Header header;

    public Packet() {
    }

    public String getAction() {
        return header.getAction();
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }
}
