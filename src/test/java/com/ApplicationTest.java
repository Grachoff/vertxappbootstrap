package com;

import com.altarix.Application;
import io.vertx.core.Vertx;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(VertxUnitRunner.class)
public class ApplicationTest {
    private Vertx vertx;

    @Before
    public void setUp(TestContext context) throws Exception {
        vertx = Vertx.vertx();
        vertx.deployVerticle(Application.class.getName(), context.asyncAssertSuccess());
    }

    @After
    public void tearDown(TestContext context) throws Exception {
        vertx.close(context.asyncAssertSuccess());
    }

    @Test
    public void test(TestContext context) throws Exception {
        Async async = context.async();
        vertx
                .createHttpClient()
                .getNow(8083, "localhost", "/", response -> response.handler(
                        body -> {
                            context.assertTrue(body.toString().contains("OK"));
                            async.complete();
                        }
                ));
    }
}