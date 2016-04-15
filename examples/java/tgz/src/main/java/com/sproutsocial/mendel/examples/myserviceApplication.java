package com.sproutsocial.mendel.examples;

import com.sproutsocial.mendel.examples.resources.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class myserviceApplication extends Application<myserviceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new myserviceApplication().run(args);
    }

    @Override
    public String getName() {
        return "myservice";
    }

    @Override
    public void initialize(final Bootstrap<myserviceConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final myserviceConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new HelloResource(configuration));
    }

}
