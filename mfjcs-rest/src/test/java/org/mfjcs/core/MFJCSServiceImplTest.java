package org.mfjcs.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mfjcs.core.SolrConstants.VERSION_FIELD;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Collections;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.common.SolrDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mfjcs.api.IndexOperationFailedException;
import org.mfjcs.api.Item;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MFJCSServiceImplTest {

	@InjectMocks
	private MFJCSServiceImpl service;
	
	@Mock
	private CloudSolrClient client;

	@Mock
	private SolrDocument solrDoc;
	private static final long VERSION = 123L;

	@Test
	public void getsItemFromSolrClient() throws ItemNotFoundException, IndexOperationFailedException, IOException, SolrServerException {
		when(client.getById("myId")).thenReturn(solrDoc);
		when(solrDoc.getFieldValue(VERSION_FIELD)).thenReturn(VERSION);
		when(solrDoc.getFieldNames()).thenReturn(Collections.singletonList("foo"));
		when(solrDoc.getFieldValue("foo")).thenReturn("bar");

		Item item = service.getItem("myId");

		assertThat(item.getMetadata().getId()).isEqualTo("myId");
		assertThat(item.getMetadata().getVersion()).isEqualTo(VERSION);
		assertThat(item.getMetadata().getAuthor()).isEqualTo("unknown");
		assertThat(item.getFields()).isEqualTo(Collections.singletonMap("foo", "bar"));
	}
}