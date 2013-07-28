package io.business.conditions;

import io.business.Product;
import io.business.properties.Name;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author zerodi
 */
public class HasNameTest {
    private HasName hasTestName;

    @BeforeMethod
    public void setUp() {
        hasTestName = new HasName("test");
    }

    @Test
    public void checkingPropertyForNameTestShouldReturnTrue() throws Exception {
        // given
        Name name = new Name("test");

        // then
        assertThat(hasTestName.validate(name)).isTrue();
    }

    @Test
    public void checkingPropertyForRandomNameShouldReturnFalse() throws Exception {
        // given
        Name name = new Name("ashkjdf");

        // then
        assertThat(hasTestName.validate(name)).isFalse();
    }

    @Test
    public void checkingProductForNameTestShouldReturnTrue() throws Exception {
        // given
        Product product = new Product().withProperties(new Name("test"));

        // then
        assertThat(hasTestName.validate(product)).isTrue();
    }

    @Test
    public void checkingProductForRandomNameShouldReturnFalse() throws Exception {
        // given
        Product product = new Product().withProperties(new Name("ahskjdhfjk"));

        // then
        assertThat(hasTestName.validate(product)).isFalse();
    }
}
