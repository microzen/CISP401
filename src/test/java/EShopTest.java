import eshop.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EShopTest {
    Supplier supplier;

    // dependency injection a shopping cart
    class TestCustomer extends Customer {
        public TestCustomer(String email, String password, ShoppingCart cart) {
            super(email, password);
            this.cart = cart;
        }
    }

    ShoppingCart cart;
    Customer customer;

    void mainInit() {
        supplier = new Supplier("Amazon");
        List<Product> products = new ArrayList<>();
        products.add(new Product("1", "apple", 3.99, supplier, 10));
        products.add(new Product("2", "cake", 2.99, supplier, 100));
        products.add(new Product("3", "milk", 5.99, supplier, 1000));
        supplier.setProducts(products.toArray(new Product[products.size()]));
        cart = new ShoppingCart();
        customer = new TestCustomer("test@mail", "123456", cart);
    }

    @Test
    void supplierTest() {
        this.mainInit();

        Assertions.assertNotNull(supplier);
        Assertions.assertNotNull(supplier.getProducts());


        Assertions.assertEquals(3, this.supplier.getProducts().length);
        Assertions.assertEquals(3.99, this.supplier.getProducts()[0].getPrice());
        Assertions.assertEquals(100, this.supplier.getProducts()[1].getStock());

    }

    @Test
    void productTest() {
        this.mainInit();
        Product apple = supplier.getProducts()[0];
        Product cake = supplier.getProducts()[1];
        Product milk = supplier.getProducts()[2];
        Assertions.assertTrue(apple.addStock(100));
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            cake.setPrice(-10);
        });
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            cake.setStock(-10);
        });
        Assertions.assertEquals(110, apple.getStock());
        Assertions.assertFalse(apple.addStock(-111));
        Assertions.assertTrue(apple.addStock(-110));
    }

    @Test
    void shoppingCartTest() {
        this.mainInit();
        Product apple = supplier.getProducts()[0];
        Product cake = supplier.getProducts()[1];
        Product milk = supplier.getProducts()[2];
        Assertions.assertFalse(cart.addProduct(apple, 20));
        Assertions.assertTrue(cart.addProduct(apple, 10));
        Assertions.assertTrue(cart.removeItem(apple));
        Assertions.assertFalse(cart.removeItem(apple));

        Assertions.assertEquals(0, cart.getTotalPirce());

        cart.addProduct(cake, 10);
        cart.addProduct(apple, 10);

        Assertions.assertEquals(10 * 3.99 + 10 * 2.99, cart.getTotalPirce());

        cart.clear();
        Assertions.assertEquals(0, cart.getTotalPirce());


    }

    @Test
    void paymentTest() {
        PaymentInfo paymentInfo = new PaymentInfo("123456", "Ye", 123, "Sacramento");
        Assertions.assertEquals(123, paymentInfo.getCVV());
        Assertions.assertEquals("123456", paymentInfo.getNumber());
        Assertions.assertEquals("Ye", paymentInfo.getName());
        Assertions.assertEquals("Sacramento", paymentInfo.getAddress());

        paymentInfo.setName("John");
        paymentInfo.setCvv(321);
        paymentInfo.setAddress("San Francisco");
        paymentInfo.setNumber("98881");

        Assertions.assertEquals("John", paymentInfo.getName());
        Assertions.assertNotEquals("123456", paymentInfo.getNumber());
        Assertions.assertEquals(321, paymentInfo.getCVV());
        Assertions.assertEquals("San Francisco", paymentInfo.getAddress());
    }

    @Test
    void shoppingTest() {
        this.mainInit();
        Assumptions.assumeFalse(customer.addItemToCart(this.supplier.getProducts()[0], 11));
        Assertions.assertEquals(0, cart.getTotalPirce());
        Assumptions.assumeTrue(customer.addItemToCart(this.supplier.getProducts()[0], 10));
        Assertions.assertEquals(3.99 * 10, cart.getTotalPirce());
    }
}
