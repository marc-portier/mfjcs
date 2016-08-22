package org.mfjcs;

import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.mfjcs.api.MFJCSService;
import org.mfjcs.core.MFJCSServiceImpl;
import org.mfjcs.health.SolrClientHealthCheck;
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
        CloudSolrClient solrClient = new CloudSolrClient.Builder()
                .withZkHost(configuration.getSolrZkHost())
                .build();

        MFJCSService mfjcs = new MFJCSServiceImpl(solrClient, configuration.getSolrItemCollection());
        environment.healthChecks().register("solr-item-collection-ping", new SolrClientHealthCheck(solrClient, configuration.getSolrPingMaxElapsedTime(), configuration.getSolrItemCollection()));
        environment.jersey().register(new ItemResource(mfjcs));
    }

}
