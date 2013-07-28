package io.business.properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author zerodi
 */
public class NameTest {
    private Name name;

    @BeforeMethod
    public void setUp() {
        this.name = new Name("test");
    }

    @Test
    public void settingANameShouldAllowItToBeRetrieved() throws Exception {
        // given
        name = new Name("name");

        // then
        assertThat(name.getName()).isEqualTo("name");
    }

    @Test
    public void twoPropertiesWithTheSameNameAreEqual() throws Exception {
        // given
        Name name2 = new Name("test");

        // then
        assertThat(name2).isEqualTo(name);
    }
}
