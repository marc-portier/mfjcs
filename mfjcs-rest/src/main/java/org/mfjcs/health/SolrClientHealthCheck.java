package org.mfjcs.health;

import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.SolrPingResponse;

import com.codahale.metrics.health.HealthCheck;

public class SolrClientHealthCheck extends HealthCheck {

	private CloudSolrClient solrClient;
	private Long pingMaxElapsedTime;
	private String collectionName;

	public SolrClientHealthCheck(CloudSolrClient solrClient, Long pingMaxElapsedTime, String collectionName) {
		this.solrClient = solrClient;
		this.pingMaxElapsedTime = pingMaxElapsedTime;
		this.collectionName = collectionName;
	}

	@Override
	protected Result check() throws Exception {
		solrClient.setDefaultCollection(collectionName);
		SolrPingResponse pingResponse = solrClient.ping();

		if (pingResponse.getStatus() != 200) {
			return Result.unhealthy("Ping response was not 200");
		}
		if (pingResponse.getElapsedTime() > pingMaxElapsedTime) {
			return Result.unhealthy(String.format("Ping response elapsed time too large (%d, max %d)", pingResponse.getElapsedTime(), pingMaxElapsedTime));
		}

		return Result.healthy();
	}
}
