package io.business;

/**
 * Payment class, which represents a payment in relation to a product, optionally specifying a reason for a payment.
 * @author zerodi
 */
public class Payment {

    private Product product;
    private Reason reason;

    public Payment(Product product) {
        this.product = product;
        product.setRelatedPayment(this);
    }

    public void setProduct(Product product) {
        this.product = product;
        product.setRelatedPayment(this);
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
