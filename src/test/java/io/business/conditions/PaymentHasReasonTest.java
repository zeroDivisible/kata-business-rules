package io.business.conditions;

import io.business.Payment;
import io.business.Product;
import io.business.Reason;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author zerodi
 */
public class PaymentHasReasonTest {
    private Payment payment;


    @BeforeMethod
    public void setUp() throws Exception {
        payment = new Payment(new Product());
    }

    @Test
    public void newPaymentShouldNotHaveAReason() throws Exception {
        // then
        assertThat(payment.getReason()).isNull();
    }

    @Test
    public void settingAReasonShouldAllowToRetrieveIt() throws Exception {
        // given
        payment.setReason(Reason.PAYMENT);

        // then
        assertThat(payment.getReason()).isEqualTo(Reason.PAYMENT);
    }
}
