package com.nova.ServerBridge;

import com.nova.ServerBridge.Protocol.Authenticate;
import com.nova.ServerBridge.Protocol.History;
import com.nova.ServerBridge.Protocol.RoomInfo;
import com.nova.ServerBridge.Protocol.Serializer;

/**
 * Created by Zakariyya Raji on 2018-1-4.
 * <p>
 * Handles callbacks from the database.
 */

enum DatabaseHandler {
    HISTORY {
        @Override
        void process(String data, ChatConnector connector) {
            History history = (History) Serializer.unpack(data, History.class);
            connector.sendBus(history.getHeader().consumeTag(), history);
        }
    },

    ROOM {
        @Override
        void process(String data, ChatConnector connector) {
            RoomInfo room = (RoomInfo) Serializer.unpack(data, RoomInfo.class);
            connector.sendBus(room.getHeader().consumeTag(), room);
        }
    },

    AUTHENTICATE {
        @Override
        void process(String data, ChatConnector connector) {
            Authenticate authenticate = (Authenticate) Serializer.unpack(data, Authenticate.class);
            connector.sendBus(authenticate.getHeader().consumeTag(), authenticate);
        }
    };

    abstract void process(String packet, ChatConnector connector);
}
