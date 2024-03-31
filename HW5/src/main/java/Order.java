import java.util.ArrayList;
import java.util.List;
class Order {
    public List<FoodInterface> orderItems = new ArrayList<>();

    public void addOrderItems(FoodInterface item){
        orderItems.add(item);
    }

    public int orderAmount(){
        int amount = 0;
        for(FoodInterface item : orderItems){
            amount = amount + item.getPrice();
        }
        return amount;
    }

    public double orderAmountCustomerLoyalty(CustomerLoyalty customerLoyalty){
        double amount = orderAmount();
        return customerLoyalty.applyDiscount(amount);
    }



}
