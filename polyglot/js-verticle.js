var server = vertx.createHttpServer();
var SayHello = Java.type('com.follett.fss.diy2019.vertx.polyglot.SayHello');

var hello = new SayHello();

server.requestHandler(function (request) {
    request.response().end('JavaScript ' + hello.hello());
});
server.listen(8080);