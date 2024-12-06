package com.nova.ServerBridge.Model;

import com.nova.ServerBridge.Protocol.RoomEvent;

/**
 * Created by Zakariyya Raji on 2017-12-19-12-18.
 * <p>
 * Room data stored in the Registry.
 */
public class Room {
    private String room;

    public Room(String room) {
        this.room = room;
    }

    public Room(RoomEvent room) {
        this.room = room.getRoom();
    }

    public String getName() {
        return room;
    }

    public void setName(String name) {
        this.room = name;
    }
}
