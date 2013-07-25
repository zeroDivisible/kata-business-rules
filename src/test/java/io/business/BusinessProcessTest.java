package io.business;

import io.business.conditions.IsPhysical;
import io.business.properties.Physical;
import io.business.results.Result;
import io.business.workflows.BusinessProcess;
import io.business.results.PackingSlip;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isA;


/**
 * @author zerodi
 */
public class BusinessProcessTest {
    private BusinessProcess businessProcess;


    @BeforeMethod
    public void setUp() {
        businessProcess = new BusinessProcess();
    }

    @Test
    public void newBusinessProcessHasNoConditions() {
        // then
        assertThat(businessProcess.getConditions(), hasSize(0));
    }

    @Test
    public void newBusinessProcessHasNoResults() {
        // then
        assertThat(businessProcess.getResults(), hasSize(0));
    }

    @Test
    public void addingConditionAndARuleShouldBeReportedProperly() throws Exception {
        // given
        businessProcess = physicalProcess();

        // then
        assertThat(businessProcess.getConditions(), hasSize(1));
        assertThat(businessProcess.getConditions(), hasItem(isA(IsPhysical.class)));
        assertThat(businessProcess.getResults(), hasSize(1));
        assertThat(businessProcess.getResults(), hasItem(isA(PackingSlip.class)));
    }

    @Test
    public void blankProcessDoesntProduceAnyResultsAfterProcessing() throws Exception {
        // then
        assertThat(businessProcess.process(new Product()), hasSize(0));
    }


    @Test
    public void processCheckingPhysicalPropertiesProducesAPackingSlip() {
        // given
        businessProcess = physicalProcess();
        Product product = new Product();
        product.addProperty(new Physical(true));

        // when
        Collection<Result> processingResult = businessProcess.process(product);

        // then
        assertThat(processingResult, hasSize(1));
        assertThat(processingResult, hasItem(isA(PackingSlip.class)));
    }


    public static BusinessProcess physicalProcess() {
        BusinessProcess process = new BusinessProcess();
        process.addCondition(new IsPhysical(true));
        process.addResult(new PackingSlip());

        return process;
    }
}
