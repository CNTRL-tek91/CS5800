class ToppingFood implements FoodInterface {
    private String toppingName;
    private int toppingPrice;

    public ToppingFood(String toppingName, int toppingPrice){
        this.toppingName = toppingName;
        this.toppingPrice = toppingPrice;
    }


    public int getPrice(){
        return toppingPrice;
    }

    public String getToppingName() { return toppingName; }


}
