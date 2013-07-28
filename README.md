kata-business-rules
===================

Code which tries to solve code kata defined here: http://codekata.pragprog.com/2007/01/kata_sixteen_bu.html

## Overview of solution
To solve this one I had used Java (which is not as sexy as Ruby or JS, though it got the job done) as the language and [TestNG](http://testng.org/doc/index.html) as the testing framework and [FEST Assertions](https://code.google.com/p/fest/) to ease the pain of writing test methods.

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
