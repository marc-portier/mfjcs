package org.mfjcs.core;

import static java.util.UUID.randomUUID;
import static org.mfjcs.core.SolrConstants.VERSION_FIELD;

import java.io.IOException;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.mfjcs.api.CreateItemRequest;
import org.mfjcs.api.IndexOperationFailedException;
import org.mfjcs.api.Item;
import org.mfjcs.api.MFJCSService;

import com.google.common.collect.Maps;

public class MFJCSServiceImpl implements MFJCSService {

	private CloudSolrClient solrClient;
	private String itemCollection;

	public MFJCSServiceImpl(CloudSolrClient solrClient, String itemCollection) {
		this.solrClient = solrClient;
		this.itemCollection = itemCollection;
	}

	@Override
	public Item getItem(String uuid) throws IndexOperationFailedException {
		SolrDocument solrDoc;
		try {
			solrClient.setDefaultCollection(itemCollection);
			solrDoc = solrClient.getById(uuid);

			// TODO: throw ItemNotFoundException if solrDoc is null

		} catch (SolrServerException | IOException e) {
			throw new IndexOperationFailedException(e);
		}
		return new ItemImpl(uuid, (Long)solrDoc.getFieldValue(VERSION_FIELD), solrDocItemFields(solrDoc));
	}

	private Map<String, Object> solrDocItemFields(SolrDocument solrDoc) {
		Map<String, Object> result = Maps.newHashMap();
		solrDoc.getFieldNames().forEach(f ->
			result.put(f, solrDoc.getFieldValue(f)));
		return result;
	}

	@Override
	public Item createNewItem(CreateItemRequest createItemRequest) throws IndexOperationFailedException {
		ItemImpl item = new ItemImpl(randomUUID().toString(), System.currentTimeMillis(), createItemRequest.getFields());

		// TODO: persist item on filesystem item store

		SolrInputDocument inputDoc = new SolrInputDocument();
		createItemRequest.getFields().forEach(inputDoc::addField);
		try {
			solrClient.setDefaultCollection(itemCollection);
			solrClient.add(itemCollection, inputDoc);
		} catch (SolrServerException | IOException e) {
			throw new IndexOperationFailedException(e);
		}
		return item;
	}
}
