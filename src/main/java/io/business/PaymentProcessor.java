package io.business;

import io.business.properties.Physical;
import io.business.results.PackingSlip;
import io.business.results.Result;
import io.business.workflows.BusinessProcess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zerodi
 */
public class PaymentProcessor {

    private Collection<BusinessProcess> businessProcesses = new ArrayList<>();

    public Collection<Result> process(Product product) {
        List<Result> returnValues = new ArrayList<>();

        if (product.hasProperty(Physical.class)) {
            returnValues.add(new PackingSlip());
        }

        return returnValues;
    }


    public Collection<BusinessProcess> getBusinessProcesses() {
        return businessProcesses;
    }

    public void addBusinessProcess(BusinessProcess businessProcess) {
        this.businessProcesses.add(businessProcess);
    }
}
