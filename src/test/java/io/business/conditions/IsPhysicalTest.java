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
    private IsPhysical isNotPhysical;

    @BeforeMethod
    public void setUp() throws Exception {
        isPhysical = new IsPhysical(true);
        isNotPhysical = new IsPhysical(false);
    }

    @Test
    public void validatingPropertiesShouldBeTrueForPhysicalProperties() throws Exception {
        // given
        Physical physical = new Physical(true);

        // then
        assertThat(isPhysical.validate(physical), is(true));
        assertThat(isNotPhysical.validate(physical), is(false));
    }

    @Test
    public void validatingPropertiesBeFalseForAnyNonPhysicalProperty() throws Exception {
        // given
        Physical physical = new Physical(false);

        // then
        assertThat(isPhysical.validate(physical), is(false));
        assertThat(isNotPhysical.validate(physical), is(true));
    }
}
