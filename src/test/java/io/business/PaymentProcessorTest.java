package io.business;

import io.business.properties.Physical;
import io.business.results.PackingSlip;
import io.business.results.Result;
import io.business.processes.BusinessProcess;
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
    private Product product;
    private BusinessProcess businessProcess;

    @BeforeMethod
    public void setUp() {
        paymentProcessor = new PaymentProcessor();
        product = new Product();
        businessProcess = new BusinessProcess();
    }

    @Test
    public void paymentForPhysicalProductGeneratesPackingSlip() throws Exception {
        // given
        Collection<Result> results;
        product.addProperty(new Physical(true));
        businessProcess = BusinessProcessTest.physicalProcess();
        paymentProcessor.addBusinessProcess(businessProcess);

        // when
        results = paymentProcessor.process(new Payment(product));

        // then
        assertThat(results, hasItem(isA(PackingSlip.class)));
    }

    @Test
    public void paymentForNonPhysicalProductDoesntProduceAPackingSlip() throws Exception {
         // given
        Collection<Result> results;
        product.addProperty(new Physical(false));
        businessProcess = BusinessProcessTest.physicalProcess();
        paymentProcessor.addBusinessProcess(businessProcess);

        // when
        results = paymentProcessor.process(new Payment(product));

        // then
        assertThat(results, not(hasItem(isA(PackingSlip.class))));
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
        paymentProcessor.addBusinessProcess(businessProcess);

        // then
        assertThat(paymentProcessor.getBusinessProcesses(), hasSize(1));
    }
}
