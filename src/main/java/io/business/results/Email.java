package io.business.results;

import io.business.Product;

/**
 * @author zerodi
 */
public class Email implements Result {

    private final String message;

    public Email(String message) {
        this.message = message;
    }

    @Override
    public void on(Product product) {
        // pass
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "{Email -> message [" + message + "]}";
    }

}
