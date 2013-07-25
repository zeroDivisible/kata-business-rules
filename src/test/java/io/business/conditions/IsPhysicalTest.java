package io.business.conditions;

import io.business.properties.Physical;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * @author zerodi
 */
public class IsPhysicalTest {
    private IsPhysical isPhysical;

    @BeforeMethod
    public void setUp() throws Exception {
        isPhysical = new IsPhysical();
    }

    @Test
    public void validateShouldBeTrueForPhysicalProperties() throws Exception {
        // given
        Physical physical = new Physical(true);

        // then
        assertThat(isPhysical.validate(physical), is(true));
    }

    @Test
    public void validateShouldBeFalseForAnyNonPhysicalProperty() throws Exception {
        // given
        Physical physical = new Physical(false);

        // then
        assertThat(isPhysical.validate(physical), is(false));
    }
}
