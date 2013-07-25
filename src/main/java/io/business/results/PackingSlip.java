package io.business.results;

import io.business.Product;

/**
 * @author zerodi
 */
public class PackingSlip implements Result {
    private Product product = null;

    @Override
    public void from(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
