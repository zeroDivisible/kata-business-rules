package io.business.results;

import io.business.Product;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * @author zerodi
 */
public class PackingSlipTest {
    private PackingSlip packingSlip;

    @BeforeMethod
    public void setUp() {
        packingSlip = new PackingSlip();
    }

    @Test
    public void newPackingSlipDoesntHaveAProduct() throws Exception {
        // then
        assertThat(packingSlip.getProduct(), nullValue());
    }


    @Test
    public void assigningAProductWontProduceNullValue() throws Exception {
        // given
        packingSlip.on(new Product());

        // then
        assertThat(packingSlip.getProduct(), notNullValue());
    }

    @Test
    public void assigningASpecificProductWillAllowToRetrieveIt() throws Exception {
        // given
        Product product = new Product();

        // when
        packingSlip.on(product);

        // then
        assertThat(packingSlip.getProduct(), is(product));
    }

    @Test
    public void packingSlipCanBeAddressedToDepartment() throws Exception {
        // given
        packingSlip.setDepartment("Royalty Department");

        // then
        assertThat(packingSlip.getDepartment(), is(equalTo("Royalty Department")));
    }
}
