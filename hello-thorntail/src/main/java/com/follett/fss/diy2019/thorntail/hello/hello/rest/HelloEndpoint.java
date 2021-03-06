package com.follett.fss.diy2019.thorntail.hello.hello.rest;


import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;


@Path("/hello")
public class HelloEndpoint {

	private final AtomicLong counter = new AtomicLong();
	
	@GET
	@Produces("text/plain")
	public Response doGet() {
		return Response.ok("Hello DIYConf2019 (" + counter.incrementAndGet() + ")").build();
	}
}
