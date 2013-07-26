package io.business.conditions;

import io.business.Product;
import io.business.properties.Type;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;


/**
 * @author zerodi
 */
public class IsTypeTest {
    private IsType bookCheck;

    @BeforeMethod
    public void setUp() {
        bookCheck = new IsType("book");
    }

    @Test
    public void typeBookShouldBeOfTypeBook() throws Exception {
        // given
        Type book = new Type("book");

        // then
        assertThat(bookCheck.validate(book)).isEqualTo(true);
    }

    @Test
    public void productOfTypeBookShouldBeValidatedAsBook() throws Exception {
        // given
        Product product = new Product();
        product.addProperty(new Type("book"));

        // then
        assertThat(bookCheck.validate(product)).isEqualTo(true);
    }
}
