package io.business.results;

import io.business.Payment;
import io.business.Product;
import io.business.Reason;

import static org.fest.assertions.Fail.fail;

/**
 * @author zerodi
 */
public class GenerateExtraPayment implements Result{

    private final Reason paymentReason;
    private final String receiver;
    private Payment originatingPayment;

    public GenerateExtraPayment(String receiver, Reason paymentReason) {
        this.receiver = receiver;
        this.paymentReason = paymentReason;

    }

    @Override
    public void on(Product product) {
        originatingPayment = product.getRelatedPayment();
    }

    public Reason getPaymentReason() {
        return paymentReason;
    }

    public String getReceiver() {
        return receiver;
    }

    public Payment getOriginatingPayment() {
        return originatingPayment;
    }

    @Override
    public String toString() {
        return "{GenerateExtraPayment -> [receiver = " + receiver + ", paymentReason = " + paymentReason + "]}";
    }
}
