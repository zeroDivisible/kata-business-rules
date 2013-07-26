package io.business;

import com.beust.jcommander.internal.Lists;
import io.business.conditions.Condition;
import io.business.conditions.HasState;
import io.business.conditions.IsPhysical;
import io.business.conditions.IsType;
import io.business.properties.Physical;
import io.business.properties.State;
import io.business.properties.Type;
import io.business.results.ChangeState;
import io.business.results.Email;
import io.business.results.Result;
import io.business.processes.BusinessProcess;
import io.business.results.PackingSlip;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;


/**
 * @author zerodi
 */
public class BusinessProcessTest {
    private BusinessProcess businessProcess;
    private Product product;


    @BeforeMethod
    public void setUp() {
        businessProcess = new BusinessProcess();
        product = new Product();
    }

    @Test
    public void newBusinessProcessHasNoConditions() {
        // then
        assertThat(businessProcess.getConditions()).isEmpty();
    }

    @Test
    public void newBusinessProcessHasNoResults() {
        // then
        assertThat(businessProcess.getResults()).isEmpty();
    }

    @Test
    public void addingConditionAndARuleShouldBeReportedProperly() throws Exception {
        // given
        businessProcess = physicalProcess();
        List<Condition> businessProcessConditions = Lists.newArrayList(businessProcess.getConditions());
        List<Result> businessProcessResults = Lists.newArrayList(businessProcess.getResults());

        // then
        assertThat(businessProcessConditions).hasSize(1);
        assertThat(businessProcessConditions.get(0)).isInstanceOf(IsPhysical.class);
        assertThat(businessProcessResults).hasSize(1);
        assertThat(businessProcessResults.get(0)).isInstanceOf(PackingSlip.class);
    }

    @Test
    public void blankProcessDoesntProduceAnyResultsAfterProcessing() throws Exception {
        // then
        assertThat(businessProcess.process(new Payment(new Product()))).hasSize(0);
    }


    @Test
    public void processCheckingPhysicalPropertiesProducesAPackingSlip() {
        // given
        businessProcess = physicalProcess();
        product.addProperty(new Physical(true));

        // when
        Collection<Result> processingResult = businessProcess.process(new Payment(product));

        // then
        assertThat(processingResult).hasSize(1);
        assertThat(processingResult.iterator().next()).isInstanceOf(PackingSlip.class);
    }

    @Test
    public void paymentForABookShouldCreatePackingSlipForRoyaltyDepartment() throws Exception {
        // given
        businessProcess = secondProcess();
        product.addProperty(new Type("book"));

        // when
        ArrayList<Result> results = new ArrayList<>();
        results.addAll(businessProcess.process(new Payment(product)));

        // then
        assertThat(results).hasSize(1);
        assertThat(results.get(0)).isInstanceOf(PackingSlip.class);
        assertThat(((PackingSlip)results.get(0)).getDepartment()).isEqualToIgnoringCase("Royalty Department");
    }

    @Test
    public void paymentForAMembershipShouldActiveThatMembership() {
        // given
        businessProcess = thirdProcess();
        product.addProperty(new Type("Membership"));

        // when
        businessProcess.process(new Payment(product));

        // then
        assertThat(product.getProperty(State.class)).isEqualTo(State.ACTIVE);
    }


    @Test
    public void paymentForActiveMembershipShouldUpgradeTheMembership() {
        // given
        businessProcess = fourthProcess();
        product.addProperty(new Type("Membership"));
        product.addProperty(State.ACTIVE);

        // when
        businessProcess.process(new Payment(product));

        // then
        assertThat(product.getProperty(State.class)).isEqualTo(State.UPGRADED);
    }


    @Test
    public void paymentForAMembershipShouldGenerateAnEmailAboutTheActivation() {
        // given
        businessProcess = fifthProcess();
        product.addProperty(new Type("Membership"));
        product.addProperty(State.INACTIVE);

        // when
        ArrayList<Result> results = new ArrayList<>();
        results.addAll(businessProcess.process(new Payment(product)));

        // then
        assertThat(results).hasSize(2);
        assertThat(results.get(0)).isInstanceOf(ChangeState.class);
        assertThat(((ChangeState)results.get(0)).getTargetState()).isEqualTo(State.ACTIVE);
        assertThat(results.get(1)).isInstanceOf(Email.class);
        assertThat(((Email)results.get(1)).getMessage()).containsIgnoringCase("Membership activated.");
    }

    private BusinessProcess fifthProcess() {
        BusinessProcess process= new BusinessProcess();
        process.addCondition(new IsType("Membership"));
        process.addCondition(new HasState(State.INACTIVE));
        process.addResult(new ChangeState(State.ACTIVE));
        process.addResult(new Email("Membership activated."));
        return process;
    }

    public static BusinessProcess physicalProcess() {
        BusinessProcess process = new BusinessProcess();
        process.addCondition(new IsPhysical(true));
        process.addResult(new PackingSlip());
        return process;
    }

    public static BusinessProcess secondProcess() {
        BusinessProcess process = new BusinessProcess();
        process.addCondition(new IsType("book"));
        process.addResult(new PackingSlip("Royalty Department"));
        return process;
    }

    private BusinessProcess thirdProcess() {
        BusinessProcess process = new BusinessProcess();
        process.addCondition(new IsType("Membership"));
        process.addResult(new ChangeState(State.ACTIVE));
        return process;
    }

    private static BusinessProcess fourthProcess() {
        BusinessProcess process = new BusinessProcess();
        process.addCondition(new IsType("Membership"));
        process.addCondition(new HasState(State.ACTIVE));
        process.addResult(new ChangeState(State.UPGRADED));
        return process;
    }
}
