package org.mfjcs;

import org.mfjcs.resources.ItemResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MFJCSApplication extends Application<MFJCSConfiguration> {

    public static void main(final String[] args) throws Exception {
        new MFJCSApplication().run(args);
    }

    @Override
    public String getName() {
        return "MFJCS";
    }

    @Override
    public void initialize(final Bootstrap<MFJCSConfiguration> bootstrap) {
    }

    @Override
    public void run(final MFJCSConfiguration configuration,
                    final Environment environment) {
        //TODO: create MfjcsService, constructor-inject a blobstore and a solrj client
        //TODO: add health checks

        environment.jersey().register(new ItemResource());
    }

}
