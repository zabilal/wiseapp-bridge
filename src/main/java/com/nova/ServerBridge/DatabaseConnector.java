package com.nova.ServerBridge;

import com.nova.ServerBridge.Protocol.Serializer;
import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

/**
 * Created by Zakariyya Raji on 2017-12-22.
 * <p>
 * Pass messages to the database, on reply put back on the bus.
 */
class DatabaseConnector extends AbstractVerticle {
    private Vertx vertx;

    @Override
    public Vertx getVertx() {
        return vertx;
    }

    @Override
    public void init(Vertx vertx, Context context) {
        this.vertx = vertx;
    }

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        vertx.createHttpClient().websocket(Configuration.DATABASE_PORT, "localhost", "/", event -> {

            event.handler(data -> {
                sendBus(Configuration.BUS_DATABASE_RESPONSE, data.toString());
            });

            vertx.eventBus().consumer(Configuration.BUS_DATABASE_REQUEST, handler -> {
                sendBus(event.textHandlerID(), handler.body().toString());
            });
        });
    }

    private void sendBus(String address, String data) {
        vertx.eventBus().send(address, data);
    }

    @Override
    public void stop(Future<Void> stopFuture) throws Exception {

    }
}
