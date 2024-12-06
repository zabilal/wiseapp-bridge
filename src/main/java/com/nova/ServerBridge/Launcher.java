package com.nova.ServerBridge;

import io.vertx.core.*;

/**
 * Created by Zakariyya Raji on 2017-12-22.
 * <p>
 * Launches the required AbstractVerticle for the component.
 */
public class Launcher extends AbstractVerticle {
    private Vertx vertx;

    @Override
    public Vertx getVertx() {
        return vertx;
    }

    @Override
    public void init(Vertx vertx, Context context) {
        this.vertx = vertx;
        vertx.deployVerticle(new DatabaseConnector());
        vertx.deployVerticle(new ChatConnector());
        vertx.deployVerticle(new RegistryConnector());
        vertx.deployVerticle(new Logger());
    }

    @Override
    public void start(Future<Void> startFuture) throws Exception {
    }

    @Override
    public void stop(Future<Void> stopFuture) throws Exception {
        vertx.close();
    }
}
