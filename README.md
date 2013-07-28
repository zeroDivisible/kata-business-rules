kata-business-rules
===================
To solve this one I had used Java (which is not as sexy as Ruby or JS, though it got the job done:) as the language and [TestNG](http://testng.org/doc/index.html) as the testing framework and [FEST Assertions](https://code.google.com/p/fest/) to ease the pain of writing test methods.

## Usage
Processes can be defined ad hoc (though there is [BusinessProcessHelper](https://github.com/zeroDivisible/kata-business-rules/blob/master/src/main/java/io/business/processes/BusinessProcessHelper.java) class which defines all the ones described in the problem statement, using syntaxt like the one below:

```
BusinessProcess fourthProcess = new BusinessProcess()
  .withConditions(
    new IsType("Membership"),
    new HasState(new State("ACTIVE")),
    new PaymentHasReason(Reason.UPGRADE))
  .withResults(
    new ChangeState(new State("UPGRADED")));
```

which when applied to a Payment:
```
Payment payment = new Payment(
  new Product().withProperties(
    new Type("Membership"),
    new State("ACTIVE")), Reason.UPGRADE);
```

would change the ``State`` property of that product to ``new State("UPGRADED")``.

## Overview of solution
Considering the fact, that each business rule can (and will) be something arbitrary, I had came with a simple solution and created a poor man's component system. There are 3 main groups of componentes
- ``Properties`` (which can be applied to a product)
- ``Conditions`` (which the process is checking before applying the results)
- ``Results`` (which will be produced by a process).


``Condition`` is defined as an interface:
```
public interface Condition {

    public boolean validate(Product product);
    public boolean validate(Property property);
}
```

as is ``Result``:
```
public interface Result {

    public void on(Product product);
}
```

``Property`` is an abstract class:
```
public abstract class Property {
    private Product parentProduct;

    public Product getParentProduct() {
        return parentProduct;
    }

    public void setParentProduct(Product parentProduct) {
        this.parentProduct = parentProduct;
    }
}
```

Code has ``PaymentProcessor`` class defined, which can gather different BusinessProcesses and then apply each one to each of the Payments passed to it. Each ``Payment`` has both a ``Product`` for which it's done and a ``Reason`` for the payment (generic payment, upgrade, commision, etc.)


## Test Log Output.
Just for the reference, this is log.debug() output from running BusinessProcessTest tests (tests for rules defined in problem description were run in more or less random order):
```
i.business.processes.BusinessProcess - using conditions = [{IsType -> expecting [Video]}, {HasName -> expecting [Learning To Ski]}]
i.business.processes.BusinessProcess - starting to process [{type = 'Video'}, {name = 'Learning To Ski'}, {physical = 'true'}, {Payment: reason = 'PAYMENT'}]
i.business.processes.BusinessProcess - producing results = [{AddProduct -> new product [[{type = 'Video'}, {name = 'First Aid'}, null]]}] if conditions are fulfilled
i.business.processes.BusinessProcess - produced results: [{AddProduct -> new product [[{type = 'Video'}, {name = 'First Aid'}, null]]}]
i.business.processes.BusinessProcess - using conditions = [{IsType -> expecting [book]}]
i.business.processes.BusinessProcess - starting to process [{type = 'book'}, {Payment: reason = 'null'}]
i.business.processes.BusinessProcess - producing results = [{PackingSlip -> [department = 'Royalty Department']}] if conditions are fulfilled
i.business.processes.BusinessProcess - produced results: [{PackingSlip -> [department = 'Royalty Department']}]
i.business.processes.BusinessProcess - using conditions = [{IsType -> expecting [book]}, {PaymentHasReason -> expecting [PAYMENT]}]
i.business.processes.BusinessProcess - starting to process [{type = 'book'}, {Payment: reason = 'PAYMENT'}]
i.business.processes.BusinessProcess - producing results = [{GenerateExtraPayment -> [receiver = Agent, paymentReason = COMMISSION]}] if conditions are fulfilled
i.business.processes.BusinessProcess - produced results: [{GenerateExtraPayment -> [receiver = Agent, paymentReason = COMMISSION]}]
i.business.processes.BusinessProcess - using conditions = [{IsType -> expecting [Membership]}, {PaymentHasReason -> expecting [PAYMENT]}]
i.business.processes.BusinessProcess - starting to process [{type = 'Membership'}, {Payment: reason = 'PAYMENT'}]
i.business.processes.BusinessProcess - producing results = [{ChangeState -> to [{state = 'ACTIVE'}]}] if conditions are fulfilled
i.business.processes.BusinessProcess - produced results: [{ChangeState -> to [{state = 'ACTIVE'}]}]
i.business.processes.BusinessProcess - using conditions = [{IsType -> expecting [Membership]}, {HasState -> expecting [{state = 'INACTIVE'}]}, {PaymentHasReason -> expecting [P] DEBUG i.business.processes.BusinessProcess - starting to process [{type = 'Membership'}, {state = 'INACTIVE'}, {Payment: reason = 'PAYMENT'}]
i.business.processes.BusinessProcess - producing results = [{ChangeState -> to [{state = 'ACTIVE'}]}, {Email -> message [Membership activated.]}] if conditions are fulfilled
i.business.processes.BusinessProcess - produced results: [{ChangeState -> to [{state = 'ACTIVE'}]}, {Email -> message [Membership activated.]}]
i.business.processes.BusinessProcess - using conditions = [{IsType -> expecting [Membership]}, {HasState -> expecting [{state = 'ACTIVE'}]}, {PaymentHasReason -> expecting [UPG] DEBUG i.business.processes.BusinessProcess - starting to process [{type = 'Membership'}, {state = 'ACTIVE'}, {Payment: reason = 'UPGRADE'}]
i.business.processes.BusinessProcess - producing results = [{ChangeState -> to [{state = 'UPGRADED'}]}, {Email -> message [Membership upgraded.]}] if conditions are fulfilled
i.business.processes.BusinessProcess - produced results: [{ChangeState -> to [{state = 'UPGRADED'}]}, {Email -> message [Membership upgraded.]}]
i.business.processes.BusinessProcess - using conditions = [{IsPhysical -> expecting [true]}, {PaymentHasReason -> expecting [PAYMENT]}]
i.business.processes.BusinessProcess - starting to process [{physical = 'true'}, {Payment: reason = 'PAYMENT'}]
i.business.processes.BusinessProcess - producing results = [{GenerateExtraPayment -> [receiver = Agent, paymentReason = COMMISSION]}] if conditions are fulfilled
i.business.processes.BusinessProcess - produced results: [{GenerateExtraPayment -> [receiver = Agent, paymentReason = COMMISSION]}]
i.business.processes.BusinessProcess - using conditions = [{IsType -> expecting [Membership]}, {HasState -> expecting [{state = 'ACTIVE'}]}, {PaymentHasReason -> expecting [UPG] DEBUG i.business.processes.BusinessProcess - starting to process [{type = 'Membership'}, {state = 'ACTIVE'}, {Payment: reason = 'UPGRADE'}]
i.business.processes.BusinessProcess - producing results = [{ChangeState -> to [{state = 'UPGRADED'}]}] if conditions are fulfilled
i.business.processes.BusinessProcess - produced results: [{ChangeState -> to [{state = 'UPGRADED'}]}]
i.business.processes.BusinessProcess - using conditions = [{IsPhysical -> expecting [true]}]
i.business.processes.BusinessProcess - starting to process [{physical = 'true'}, {Payment: reason = 'null'}]
i.business.processes.BusinessProcess - producing results = [{PackingSlip -> [department = '']}] if conditions are fulfilled
i.business.processes.BusinessProcess - produced results: [{PackingSlip -> [department = '']}]
```
