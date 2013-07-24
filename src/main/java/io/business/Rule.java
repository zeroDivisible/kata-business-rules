package io.business;

import io.business.conditions.Condition;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author zerodi
 */
public class Rule {
    private Collection<Condition> conditions = new ArrayList<>();
    private Collection<Result> results = new ArrayList<>();

    public Collection<?> getConditions() {
        return conditions;
    }

    public void setConditions(Condition condition) {
        this.conditions.add(condition);
    }


    public Collection<?> getResults() {
        return results;
    }

    public void addResult(Result result) {
        this.results.add(result);
    }
}
