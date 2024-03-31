

public class Decorator {
    public static void main(String[] args) {

        BaseFood burger = new BaseFood("Burger", 5);
        BaseFood pizza = new BaseFood("Pizza", 12);


        ToppingFood cheese = new ToppingFood("Cheese", 1);
        ToppingFood pepperoni = new ToppingFood("Pepperoni", 1);
        ToppingFood bacon = new ToppingFood("Bacon", 2);
        ToppingFood avocado = new ToppingFood("Avocado", 3);
        ToppingFood peppers = new ToppingFood("Peppers", 2);


        Order order = new Order();
        order.addOrderItems(burger);
        order.addOrderItems(pizza);
        order.addOrderItems(cheese);
        order.addOrderItems(pepperoni);
        order.addOrderItems(bacon);
        order.addOrderItems(avocado);
        order.addOrderItems(peppers);

        System.out.println("Main Food Item: " + burger.getFoodName());
        System.out.println("Toppings: ");
        System.out.println("\t"+ bacon.getToppingName());
        System.out.println("\t"+ avocado.getToppingName());
        System.out.println("Total cost without discount: $" + order.orderAmount());

        // Apply loyalty discount
        CustomerLoyalty customerLoyalty = new CustomerLoyalty();
        double totalCostWithDiscount = order.orderAmountCustomerLoyalty(customerLoyalty);
        System.out.println("Total cost with discount: $" + totalCostWithDiscount);

        System.out.println("Main Food Item: " + pizza.getFoodName());
        System.out.println("Toppings: ");
        System.out.println("\t"+ cheese.getToppingName());
        System.out.println("\t"+ pepperoni.getToppingName());
        System.out.println("\t"+ peppers.getToppingName());
        System.out.println("Total cost without discount: $" + order.orderAmount());

        // Apply loyalty discount
        CustomerLoyalty customerLoyalty2 = new CustomerLoyalty();
        double totalCostWithDiscount2 = order.orderAmountCustomerLoyalty(customerLoyalty2);
        System.out.println("Total cost with discount: $" + totalCostWithDiscount2);
    }
}