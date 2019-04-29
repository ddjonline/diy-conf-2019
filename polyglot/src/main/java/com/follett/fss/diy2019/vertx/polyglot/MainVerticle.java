package com.follett.fss.diy2019.vertx.polyglot;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() {
        Router router = Router.router(vertx);
        router.get("/").handler(context -> {
            SayHello hello = new SayHello();
            context.response().setStatusCode(200).end("Java " + hello.hello());
        });
        vertx.createHttpServer().requestHandler(router).listen(8080);
    }
}
