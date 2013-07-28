package io.business.conditions;

import io.business.Product;
import io.business.Reason;
import io.business.properties.Property;

/**
 * @author zerodi
 */
public class PaymentHasReason implements Condition {

    private final Reason reason;

    public PaymentHasReason(Reason reason) {
        this.reason = reason;
    }

    @Override
    public boolean validate(Product product) {
        return product.getRelatedPayment() != null
                && reason.equals(product.getRelatedPayment().getReason());
    }

    @Override
    public boolean validate(Property property) {
        return false;  //TODO Implement
    }

    @Override
    public String toString() {
        return "{PaymentHasReason -> expecting [" + reason + "]}";
    }
}
