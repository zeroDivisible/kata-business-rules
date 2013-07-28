package io.business.properties;

import io.business.Product;

/**
 * Defines a base abstract class, being a property of an object.
 * @author zerodi
 */
public abstract class Property {
    private Product parentProduct;

    public Product getParentProduct() {
        return parentProduct;
    }

    public void setParentProduct(Product parentProduct) {
        this.parentProduct = parentProduct;
    }
}
