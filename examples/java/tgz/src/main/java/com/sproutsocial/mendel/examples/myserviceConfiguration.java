package com.sproutsocial.mendel.examples;

import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

public class myserviceConfiguration extends Configuration {
    @NotEmpty
    @NotNull
    private String defaultName;

    public myserviceConfiguration() {
    }

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }
}
