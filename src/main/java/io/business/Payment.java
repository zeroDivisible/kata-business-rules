package io.business;

import java.math.BigDecimal;

/**
 * @author zerodi
 */
public class Payment {

    private Product product;
    private Reason reason;

    public Payment(Product product) {
        this.product = product;
        product.addAssociatedPayment(this);
    }

    public void setProduct(Product product) {
        this.product = product;
        product.addAssociatedPayment(this);
    }

    public Product getProduct() {
        return product;
    }

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }
}
