package io.business.workflows;

import io.business.conditions.Condition;
import io.business.results.Result;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author zerodi
 */
public class BusinessProcess {
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
}
