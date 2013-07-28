package io.business.processes;

import io.business.Payment;
import io.business.conditions.Condition;
import io.business.results.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author zerodi
 */
public class BusinessProcess {
    private static final Logger log = LoggerFactory.getLogger(BusinessProcess.class);

    private Collection<Condition> conditions = new ArrayList<>();
    private Collection<Result> results = new ArrayList<>();

    public Collection<Condition> getConditions() {
        return conditions;
    }

    public void addCondition(Condition condition) {
        this.conditions.add(condition);
    }


    public Collection<Result> getResults() {
        return results;
    }

    public void addResult(Result result) {
        this.results.add(result);
    }

    public Collection<Result> process(Payment payment) {
        log.debug("using conditions = {}", conditions);
        log.debug("starting to process {}", payment.getProduct());
        log.debug("producing results = {} if conditions are fulfilled", results);

        Collection <Result> resultCollection = new ArrayList<>();

        for (Condition condition : conditions) {
            if (!condition.validate(payment.getProduct())) {
                log.debug("condition {} wasn't fulfilled - terminating process.", condition);
                return resultCollection; // which will be empty at this stage;
            }
        }

        // but if we had reached this point, let's get results from the system.
        for (Result result : results) {
            result.on(payment.getProduct());
            resultCollection.add(result);
        }

        log.debug("produced results: {}", resultCollection);
        return resultCollection;
    }

    public BusinessProcess withConditions(Condition... processConditions) {
        for (Condition condition : processConditions) {
            this.addCondition(condition);
        }

        return this;
    }

    public BusinessProcess withResults(Result... processResults) {
        for (Result result : processResults) {
            this.addResult(result);
        }

        return this;
    }
}
