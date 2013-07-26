package io.business.results;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author zerodi
 */
public class EmailTest {
    private Email email;

    @BeforeMethod
    public void setUp() throws Exception {
        email = new Email("test");

    }

    @Test
    public void testGetMessage() throws Exception {
        // then
        assertThat(email.getMessage()).isEqualToIgnoringCase("test");
    }
}
