package org.acme;

import java.util.Objects;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import io.vertx.core.Vertx;
import org.jboss.logging.*;

@Path("/hello")
public class GreetingResource {

    private static final Logger LOG = Logger.getLogger(GreetingResource.class);

    @Inject
    public GreetingResource(Vertx vertx) {
        this.vertx = vertx;
    }

    Vertx vertx;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        LOG.info("Vertx=" + Objects.nonNull(vertx));
        return "Hello from RESTEasy Reactive";
    }
}
