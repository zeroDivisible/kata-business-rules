package io.business;

import io.business.properties.Physical;
import io.business.results.Result;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collection;

import static org.fest.assertions.Assertions.assertThat;


/**
 * @author zerodi
 */
public class PaymentProcessorTest {
    private PaymentProcessor paymentProcessor;

    @BeforeClass
    public void setUp() {
        paymentProcessor = new PaymentProcessor();
    }

    @Test
    public void paymentForPhysicalProductGeneratesPackingSlip() throws Exception {
        // given
        Collection<Result> results;
        Product product = new Product();
        product.addProperty(new Physical(true));

        // when
        results = paymentProcessor.process(product);

        // then
        assertThat(results).hasSize(1);
    }

}
