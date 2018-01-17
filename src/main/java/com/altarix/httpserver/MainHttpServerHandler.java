package com.altarix.httpserver;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainHttpServerHandler implements Handler<HttpServerRequest> {
    @Override
    public void handle(HttpServerRequest httpServerRequest) {
        httpServerRequest.absoluteURI();
        httpServerRequest.response().end("OK");
    }
}
