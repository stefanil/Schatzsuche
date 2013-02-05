package de.saxsys.schatzsuche.backend.core;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * Test the {@link ExampleBean}.
 *
 * TODO please delete
 * @author manuel.mauky
 *
 */
public class ExampleBeanTest {

	private ExampleBean bean;

	@Before
	public void setup(){
		bean = new ExampleBean();
	}


	@Test
	public void testSayHello(){
		assertThat(bean.sayHello()).isEqualTo("Hello World");
	}

}
