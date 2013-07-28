package io.business.results;

import io.business.Product;

/**
 * @author zerodi
 */
public class AddProduct implements Result {
    private final Product productToAdd;
    private Product sourceProduct;

    public AddProduct(Product productToAdd) {
        this.productToAdd = productToAdd;
    }

    @Override
    public void on(Product product) {
        this.sourceProduct = product;
    }

    public Product getProductToAdd() {
        return productToAdd;
    }

    public Product getSourceProduct() {
        return sourceProduct;
    }

    public void setSourceProduct(Product sourceProduct) {
        this.sourceProduct = sourceProduct;
    }

    @Override
    public String toString() {
        return "{AddProduct -> new product [" + productToAdd + "]}";
    }
}
