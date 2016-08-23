package org.mfjcs;

import io.dropwizard.Configuration;

public class MFJCSConfiguration extends Configuration {

	private String solrZkHost = "localhost:9983";
	private String solrItemCollection = "mfjcs-items";
	private Long solrPingMaxElapsedTime = 500L;

	public String getSolrZkHost() {
		return solrZkHost;
	}

	public void setSolrZkHost(String solrZkHost) {
		this.solrZkHost = solrZkHost;
	}

	public String getSolrItemCollection() {
		return solrItemCollection;
	}

	public void setSolrItemCollection(String solrItemCollection) {
		this.solrItemCollection = solrItemCollection;
	}

	public Long getSolrPingMaxElapsedTime() {
		return solrPingMaxElapsedTime;
	}

	public void setSolrPingMaxElapsedTime(Long solrPingMaxElapsedTime) {
		this.solrPingMaxElapsedTime = solrPingMaxElapsedTime;
	}
}
