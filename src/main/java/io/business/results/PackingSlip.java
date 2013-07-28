package io.business.results;

import io.business.Product;

/**
 * @author zerodi
 */
public class PackingSlip implements Result {
    private Product product = null;
    private String department;

    public PackingSlip(String department) {
        this.department = department;
    }

    public PackingSlip() {
    }

    @Override
    public void on(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public PackingSlip withDepartment(String department) {
        setDepartment(department);
        return this;
    }
}
