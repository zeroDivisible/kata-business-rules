package io.business;

/**
 * Payment class, which represents a payment in relation to a product, optionally specifying a reason for a payment.
 * @author zerodi
 */
public class Payment {

    private Product product;
    private Reason reason;

    /**
     * Creates a base payment with a {@link Reason} equal to {@link Reason#PAYMENT}
     */
    public Payment(Product product) {
        this.product = product;
        product.setRelatedPayment(this);
    }

    /**
     * Creates a payment with whatever reason will be specified.
     */
    public Payment(Product product, Reason reason) {
        this(product);
        this.reason = reason;
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
