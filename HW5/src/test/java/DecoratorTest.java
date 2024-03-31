import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import java.util.stream.BaseStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecoratorTest {
    @Test
    public void testCalculateTotalCost() {
        BaseFood burger = new BaseFood("Burger", 5);
        BaseFood pizza = new BaseFood("Pizza", 12);
        Order order = new Order();
        order.addOrderItems(burger);
        order.addOrderItems(pizza);
        assertEquals(7.0, order.orderAmount(), 0.001);
    }

    @Test
    public void testCalculateTotalCostWithDiscount() {
        BaseFood burger = new BaseFood("Burger", 5);
        BaseFood pizza = new BaseFood("Pizza", 12);
        Order order = new Order();
        order.addOrderItems(burger);
        order.addOrderItems(pizza);
        CustomerLoyalty loyaltyStatus = new CustomerLoyalty();
        assertEquals(6.3, order.orderAmountCustomerLoyalty(loyaltyStatus), 0.001);
    }
}