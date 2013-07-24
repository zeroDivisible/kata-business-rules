package io.business;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author zerodi
 */
public class RuleTest {
    private Rule rule;


    @BeforeMethod
    public void setUp() {
        rule = new Rule();
    }

    @Test
    public void newRuleHasNoConditions() {
        // then
        assertThat(rule.getConditions()).hasSize(0);
    }

    @Test
    public void newRuleHasNoResults() {
        // then
        assertThat(rule.getResults()).hasSize(0);
    }
}
