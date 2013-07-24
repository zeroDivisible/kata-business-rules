package io.business;

import io.business.properties.Physical;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zerodi
 */
public class BusinessProcessor {

    public Collection<Object> process(Product product) {
        List<Object> returnValues = new ArrayList<>();

        if (product.hasProperty(Physical.class)) {
            returnValues.add(new PackingSlip());
        }

        return returnValues;
    }
}
