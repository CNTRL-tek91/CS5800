
class BaseFood implements FoodInterface {
    private String foodName;
    private int foodPrice;

    public BaseFood(String foodName, int foodPrice){
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public String getFoodName(){
        return foodName;
    }

    public int getPrice(){
        return foodPrice;
    }
}
