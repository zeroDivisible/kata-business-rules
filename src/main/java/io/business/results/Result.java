package io.business.results;

import io.business.Product;

/**
 * Interface which needs to be implemented by all classes which represent a single result created by a process.
 * @author zerodi
 */
public interface Result {

    public void on(Product product);
}
