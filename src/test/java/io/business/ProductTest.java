package io.business;

import io.business.properties.Physical;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author zerodi
 */
public class ProductTest {
    Product product;

    @BeforeMethod
    public void setUp() throws Exception {
        product = new Product();
    }

    @Test
    public void productIsPhysical() throws Exception {
        // given
        product.addProperty(new Physical(true));

        // then
        assertThat(product.getProperties().size()).isEqualTo(1);
        assertThat(product.hasProperty(Physical.class)).isEqualTo(true);
    }

    @Test
    public void blankProductHasNoProperties() throws Exception {
        // then
        assertThat(product.getProperties().size()).isEqualTo(0);
    }
}
