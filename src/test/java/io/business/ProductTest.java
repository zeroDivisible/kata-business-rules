package io.business;

import io.business.properties.Physical;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;


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
        assertThat(product.getProperties(), hasSize(1));
        assertThat(product.hasProperty(Physical.class), is(true));
    }

    @Test
    public void blankProductHasNoProperties() throws Exception {
        // then
        assertThat(product.getProperties(), hasSize(0));
    }
}
