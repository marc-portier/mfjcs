package org.mfjcs.core;

import static org.joda.time.format.ISODateTimeFormat.basicDate;
import static org.joda.time.format.ISODateTimeFormat.basicDateTime;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.mfjcs.api.Item;
import org.mfjcs.api.ItemStore;
import org.mfjcs.api.ItemStoreException;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.jackson.Jackson;

public class ItemStoreImpl implements ItemStore {

	private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

	private String basePath;

	public ItemStoreImpl(String basePath) {
		this.basePath = basePath;
	}

	@Override
	public Item save(Item item) throws ItemStoreException {
		String part1 = item.getMetadata().getId().substring(0, 2);
		String part2 = item.getMetadata().getId().substring(2, 4);
		String part3 = item.getMetadata().getId().substring(4, 6);

		String date = basicDate().print(item.getMetadata().getVersion());
		String dateTime = basicDateTime().print(item.getMetadata().getVersion());
		String fileName = item.getMetadata().getId() + "_" + dateTime + ".json";

		Path filePath = Paths.get(basePath, "items", part1, part2, part3, date, fileName);

		try {
			Files.createDirectories(filePath.getParent());
			BufferedWriter bufferedWriter = Files.newBufferedWriter(filePath);

			MAPPER.writeValue(bufferedWriter, item);

			bufferedWriter.close();
		} catch (IOException e) {
			throw new ItemStoreException(e);
		}

		return null;
	}
}
