package org.mfjcs;

import org.hibernate.validator.constraints.NotEmpty;

import io.dropwizard.Configuration;

public class MFJCSConfiguration extends Configuration {

	@NotEmpty
	private String storageBasePath;

	private String solrZkHost = "localhost:9983";
	private String solrItemCollection = "mfjcs-items";
	private Long solrPingMaxElapsedTime = 500L;

	public void setSolrZkHost(String solrZkHost) {
		this.solrZkHost = solrZkHost;
	}

	public String getSolrZkHost() {
		return solrZkHost;
	}

	public void setSolrItemCollection(String solrItemCollection) {
		this.solrItemCollection = solrItemCollection;
	}

	public String getSolrItemCollection() {
		return solrItemCollection;
	}

	public void setSolrPingMaxElapsedTime(Long solrPingMaxElapsedTime) {
		this.solrPingMaxElapsedTime = solrPingMaxElapsedTime;
	}

	public Long getSolrPingMaxElapsedTime() {
		return solrPingMaxElapsedTime;
	}

	public void setStorageBasePath(String storageBasePath) {
		this.storageBasePath = storageBasePath;
	}

	public String getStorageBasePath() {
		return storageBasePath;
	}
}
