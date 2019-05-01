package com.follett.fss.diy2019.vertx.hello;

import java.util.concurrent.atomic.AtomicLong;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

    private final AtomicLong counter = new AtomicLong();

    @Override
    public void start() {

        DeploymentOptions options = new DeploymentOptions().setConfig(config());
        vertx.rxDeployVerticle(WorkerVerticle.class.getName(), options).subscribe(verticleId -> {
            Router router = Router.router(vertx);
            router.route("/hello").method(HttpMethod.GET).handler(context -> {
                context.response().end("Hello DIYConf2019 (" + counter.incrementAndGet() + ")");
            });
            router.route("/naptime").method(HttpMethod.GET).blockingHandler(context -> {
                vertx.eventBus().rxSend(WorkerVerticle.ADDRESS, 20000).subscribe(result -> {
                    if (!context.response().closed()) {
                        context.response().end("your slice of pi is " + result.body());
                    }
                });
            });
    
            vertx.createHttpServer().requestHandler(router).rxListen(8080).subscribe();
        });
    }
}
