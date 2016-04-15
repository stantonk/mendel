package com.sproutsocial.mendel.examples.resources;


import com.sproutsocial.mendel.examples.myserviceConfiguration;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.TEXT_PLAIN)
@Path(("/hello"))
public class HelloResource {

    private final myserviceConfiguration configuration;

    public HelloResource(myserviceConfiguration configuration) {
        this.configuration = configuration;
    }

    @GET
    public String getHello(@QueryParam("name") String name) {
        String theName = name == null ? configuration.getDefaultName() : name;
        return "Hello, " + theName + "!\n";
    }
}
