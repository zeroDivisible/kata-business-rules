package io.business;

import io.business.properties.Physical;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collection;

import static org.fest.assertions.Assertions.assertThat;


/**
 * @author zerodi
 */
public class BusinessProcessorTest {
    private BusinessProcessor businessProcessor;

    @BeforeClass
    public void setUp() {
        businessProcessor = new BusinessProcessor();
    }

    @Test
    public void paymentForPhysicalProductGeneratesPackingSlip() throws Exception {
        // given
        Collection<Object> results;
        Product product = new Product();
        product.addProperty(new Physical(true));

        // when
        results = businessProcessor.process(product);

        // then
        assertThat(results).hasSize(1);
    }

}
