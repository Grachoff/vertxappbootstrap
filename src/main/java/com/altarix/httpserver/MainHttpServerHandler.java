package com.altarix.httpserver;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;

public class MainHttpServerHandler implements Handler<HttpServerRequest> {
    @Override
    public void handle(HttpServerRequest httpServerRequest) {
        httpServerRequest.response().end("OK");
    }
}
