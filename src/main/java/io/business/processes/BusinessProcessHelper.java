package io.business.processes;

import io.business.Product;
import io.business.Reason;
import io.business.conditions.*;
import io.business.properties.Name;
import io.business.properties.State;
import io.business.properties.Type;
import io.business.results.*;

/**
 * This is just a helper class which creates predefined business processes.
 * @author zerodi
 */
public class BusinessProcessHelper {

    public static BusinessProcess firstProcess() {
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

    public static BusinessProcess thirdProcess() {
        BusinessProcess process = new BusinessProcess();
        process.addCondition(new IsType("Membership"));
        process.addResult(new ChangeState(new State("ACTIVE")));
        return process;
    }

    public static BusinessProcess fourthProcess() {
        BusinessProcess process = new BusinessProcess();
        process.addCondition(new IsType("Membership"));
        process.addCondition(new HasState(new State("ACTIVE")));
        process.addResult(new ChangeState(new State("UPGRADED")));
        return process;
    }

    public static BusinessProcess fifthProcessA() {
        BusinessProcess process= new BusinessProcess();
        process.addCondition(new IsType("Membership"));
        process.addCondition(new HasState(new State("INACTIVE")));
        process.addCondition(new PaymentHasReason(Reason.PAYMENT));
        process.addResult(new ChangeState(new State("ACTIVE")));
        process.addResult(new Email("Membership activated."));
        return process;
    }

    public static BusinessProcess fifthProcessB() {
        BusinessProcess process= new BusinessProcess();
        process.addCondition(new IsType("Membership"));
        process.addCondition(new HasState(new State("ACTIVE")));
        process.addCondition(new PaymentHasReason(Reason.UPGRADE));
        process.addResult(new ChangeState(new State("UPGRADED")));
        process.addResult(new Email("Membership upgraded."));
        return process;
    }


    public static BusinessProcess sixthProcess() {
        BusinessProcess process = new BusinessProcess();
        process.addCondition(new IsType("Video"));
        process.addCondition(new HasName("Learning To Ski"));
        process.addResult(new AddProduct(new Product().withProperties(
                new Type("Video"), new Name("First Aid")
        )));
        return process;
    }

    public static BusinessProcess seventhProcessA() {
        BusinessProcess process = new BusinessProcess();
        process.addCondition(new IsPhysical(true));
        process.addCondition(new PaymentHasReason(Reason.PAYMENT));
        process.addResult(new GenerateExtraPayment("Agent", Reason.COMMISSION));
        return process;
    }

    public static BusinessProcess seventhProcessB() {
        BusinessProcess process = new BusinessProcess();
        process.addCondition(new IsType("book"));
        process.addCondition(new PaymentHasReason(Reason.PAYMENT));
        process.addResult(new GenerateExtraPayment("Agent", Reason.COMMISSION));
        return process;
    }
}
