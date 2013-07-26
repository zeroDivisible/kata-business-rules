package io.business.properties;


/**
 * @author zerodi
 */
public class Type implements Property {

    private final String type;

    public Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
