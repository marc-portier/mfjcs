package org.mfjcs.core;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mfjcs.api.ItemMetadata;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ItemImplTest {

	@Mock
	ItemMetadata metadata;

	Map<String, Object> fields = Collections.singletonMap("foo", "test");

	@Test
	public void constructorSetsFields() {
		ItemImpl item = new ItemImpl(metadata, fields);

		assertThat(item.getMetadata()).isEqualTo(metadata);
		assertThat(item.getFields()).isEqualTo(fields);
	}

}