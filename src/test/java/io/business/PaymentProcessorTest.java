package io.business;

import io.business.properties.Physical;
import io.business.results.PackingSlip;
import io.business.results.Result;
import io.business.workflows.BusinessProcess;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


/**
 * @author zerodi
 */
public class PaymentProcessorTest {
    private PaymentProcessor paymentProcessor;

    @BeforeMethod
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
        assertThat(results, hasItem(isA(PackingSlip.class)));
    }

    @Test
    public void newPaymentProcessorDoesntHaveAnyWorkflows() throws Exception {
        // then
        assertThat(paymentProcessor.getBusinessProcesses(), hasSize(0));
    }

    @Test
    public void addingWorkflowShouldAddOneWorkflowToProcessor() throws Exception {
        // given
        BusinessProcess businessProcess = new BusinessProcess();

        // when
        paymentProcessor.addWorkflow(businessProcess);

        // then
        assertThat(paymentProcessor.getBusinessProcesses(), hasSize(1));
    }
}
