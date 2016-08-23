package org.mfjcs.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ItemMetadataImplTest {

	@Test
	public void constructorSetsFields() {
		String id = "myId";
		long version = 123L;
		String author = "Donald Duck";

		ItemMetadataImpl metadata = new ItemMetadataImpl(id, version, author);

		assertThat(metadata.getId()).isEqualTo(id);
		assertThat(metadata.getVersion()).isEqualTo(version);
		assertThat(metadata.getAuthor()).isEqualTo(author);
	}
}