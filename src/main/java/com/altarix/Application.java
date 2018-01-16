package com.altarix;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class Application extends AbstractVerticle {
    @Override
    public void start(Future<Void> startFuture) throws Exception {
         vertx
                 .createHttpServer()
                 .requestHandler(req -> req.response().end("OK"))
                 .listen(8083, result -> {
                    if (result.succeeded()) {
                        startFuture.complete();
                    } else {
                        startFuture.fail(result.cause());
                    }
                 });
    }
}