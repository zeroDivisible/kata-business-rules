package io.business;

import io.business.properties.Physical;
import io.business.properties.State;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;
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
        assertThat(product.getProperties()).hasSize(1);
        assertThat(product.hasProperty(Physical.class)).isTrue();
    }

    @Test
    public void blankProductHasNoProperties() throws Exception {
        // then
        assertThat(product.getProperties()).hasSize(0);
    }

    @Test
    public void puttingAPropertyInProductShouldAllowThatPropertyToBeRetrieved() {
        // when
        product.addProperty(new Physical(true));

        // then
        assertThat(product.getProperty(Physical.class)).isNotNull();
        assertThat(product.getProperty(State.class)).isNull();
    }

    @Test
    public void removingAPropertyFromProductShouldMakeItDisappear() {
        // given
        product.addProperty(State.INACTIVE);

        // when
        product.removeProperties(State.class);

        // then
        assertThat(product.hasProperty(State.class)).isFalse();
    }
}
