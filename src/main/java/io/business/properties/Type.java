package io.business.properties;


import io.business.Product;

/**
 * @author zerodi
 */
public class Type extends Property {

    private final String type;

    public Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
