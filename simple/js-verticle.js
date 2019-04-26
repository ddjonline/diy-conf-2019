var server = vertx.createHttpServer();
server.requestHandler(function (request) {
    request.response().end("Hello world");
});
server.listen(8080);