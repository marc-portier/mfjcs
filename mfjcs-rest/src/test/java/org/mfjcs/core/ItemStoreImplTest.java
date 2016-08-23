package org.mfjcs.core;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.mfjcs.api.Item;
import org.mfjcs.api.ItemStoreException;

public class ItemStoreImplTest {

	private static final String AUTHOR = "Mickey Mouse";
	private static final String ID = "12ab34cdef-blabla";
	private static final Map<String, Object> FIELDS = Collections.singletonMap("color", "yellow");

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Test
	public void createsFileAtExpectedLocation() throws ItemStoreException, IOException, InterruptedException {
		ItemStoreImpl store = new ItemStoreImpl(tempFolder.getRoot().getPath());
		long version = new DateTime(2016, 12, 31, 10, 11, 12).getMillis();
		Item item = new ItemImpl(new ItemMetadataImpl(ID, version, AUTHOR), FIELDS);
		String date = ISODateTimeFormat.basicDate().print(version);
		String dateTime = ISODateTimeFormat.basicDateTime().print(version);

		store.save(item);

		Runtime.getRuntime().exec("find " + tempFolder.getRoot()).waitFor();
		String expectedPath = tempFolder.getRoot().getPath() + "/items/12/ab/34/" + date + "/12ab34cdef-blabla_" + dateTime + ".json";
		File expectedFile = new File(expectedPath);
		assertThat(expectedFile.exists()).isTrue();
	}


}