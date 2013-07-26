package io.business.properties;

import io.business.Product;

/**
 * Defines a property of an objects. It's not an abstract class as that way we can also have enums as Properties.
 * (cheap and dirty trick to make this kata a bit easier to code)
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
