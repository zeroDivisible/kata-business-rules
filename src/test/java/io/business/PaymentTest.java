package io.business;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author zerodi
 */
public class PaymentTest {
    private Payment payment;

    @BeforeMethod
    public void setUp() {
        payment = new Payment(new Product());
    }

    @Test
    public void assigningAProductToAPaymentShouldAllowToRetrieveIt() {
        // given
        Product product = new Product();

        // when
        payment.setProduct(product);

        // then
        assertThat(payment.getProduct()).isEqualTo(product);
    }

    @Test
    public void newPaymentShouldNotHaveAReason() {
        // then
        assertThat(payment.getReason()).isNull();
    }

    @Test
    public void assigningAReasonToPaymentShouldAllowToRetrieveItLater() {
        // when
        payment.setReason(Reason.ACTIVATION);

        // then
        assertThat(payment.getReason()).isEqualTo(Reason.ACTIVATION);
    }
}
