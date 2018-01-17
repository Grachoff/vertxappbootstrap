package com.altarix;

import com.altarix.httpserver.MainHttpServerHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application extends AbstractVerticle {
    @Override
    public void start(Future<Void> startFuture) throws Exception {
         vertx
                 .createHttpServer()
                 .requestHandler(new MainHttpServerHandler())
                 .listen(8083, result -> {
                    if (result.succeeded()) {
                        startFuture.complete();
                    } else {
                        startFuture.fail(result.cause());
                    }
                 });
    }

    public static void main(String[] args) {
        try {
            Vertx vertx = Vertx.vertx();
            Application instance = new Application();
            vertx.deployVerticle(instance);
        } catch (Exception e) {
//            log.error("Exception in launcher", e);
        }
    } // END main
    @Override
    public void stop() throws Exception {
        try {
            // TODO do some stuff, detach consumers, stop timers

            // Removing all verticles
            vertx.deploymentIDs().forEach(deploymentId -> vertx.undeploy(deploymentId));
        } catch (Exception e) {
//            log.error("Exception in Launcher.stop", e);
        }
    } // END stop
} // END Launcher﻿
