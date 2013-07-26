package io.business;

import io.business.results.Result;
import io.business.processes.BusinessProcess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zerodi
 */
public class PaymentProcessor {

    private Collection<BusinessProcess> businessProcesses = new ArrayList<>();

    public Collection<Result> process(Payment payment) {
        List<Result> returnValues = new ArrayList<>();

        for (BusinessProcess businessProcess : businessProcesses) {
            returnValues.addAll(businessProcess.process(payment));
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
