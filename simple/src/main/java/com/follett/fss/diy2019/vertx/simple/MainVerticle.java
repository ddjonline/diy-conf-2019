package com.follett.fss.diy2019.vertx.simple;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() {
        Router router = Router.router(vertx);
        router.get("/").handler(context -> {
            context.response().setStatusCode(200).end("Hello, world!");
        });
        vertx.createHttpServer().requestHandler(router::accept).listen(8080);
    }
}
