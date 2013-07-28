package io.business.results;

import io.business.Reason;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author zerodi
 */
public class GenerateExtraPaymentTest {
    private GenerateExtraPayment generateExtraPayment;

    @BeforeMethod
    public void setUp() throws Exception {
        generateExtraPayment = new GenerateExtraPayment("Agent", Reason.PAYMENT);
    }

    @Test
    public void paymentToAgentShouldAllowToRetrieveTheReceiver() {
        // then
        assertThat(generateExtraPayment.getReceiver()).isEqualTo("Agent");
    }

    @Test
    public void paymentShouldShowTheReasonOfAPayment() {
        // then
        assertThat(generateExtraPayment.getPaymentReason()).isEqualTo(Reason.PAYMENT);
    }
}
