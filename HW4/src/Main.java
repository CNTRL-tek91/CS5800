import java.util.ArrayList;
import java.util.List;

class Pizza{
    private String size;
    private List<String> toppings;

    public Pizza(){
        this.toppings = new ArrayList<>();
    }

    public void setSize(String size){
        this.size = size;
    }

    public void addTopping(String topping){
        this.toppings.add(topping);
    }

    public void eat(String pizzaChainName) {
        System.out.println(pizzaChainName);
        System.out.println("\t SIze: " + size);
        System.out.println("\t Toppings: ");
        for (String topping : toppings) {
            System.out.println(topping);

        }

    }
}


class PizzaBuilder{
    private Pizza pizza;

    public PizzaBuilder(){
        this.pizza = new Pizza();
    }

    public PizzaBuilder setSize(String size){
        this.pizza.setSize(size);
        return this;
    }

    public PizzaBuilder addTopping (String topping){
        this.pizza.addTopping(topping);
        return this;
    }

    public Pizza build(){
        return this.pizza;
    }
}

public class Main{
    public static void main(String[] args){
        Pizza pizza1 = new PizzaBuilder()
                .setSize("Large")
                .addTopping("\t\t1. Pepperoni")
                .addTopping("\t\t2. Mushrooms")
                .addTopping("\t\t3. Onions")
                .build();

        Pizza pizza2 = new PizzaBuilder()
                .setSize("Small")
                .addTopping("\t\t1. Sausage")
                .addTopping("\t\t2. Bacon")

                .build();

        Pizza pizza3 = new PizzaBuilder()
                .setSize("Large")
                .addTopping("\t\t1. Chicken")
                .addTopping("\t\t2. Tomato and Basil")
                .addTopping("\t\t3. Beef")
                .addTopping("\t\t4. Ham")
                .addTopping("\t\t5. Pesto")
                .addTopping("\t\t6. Spicy Pork")
                .addTopping("\t\t7. Ham and Pineapple")
                .addTopping("\t\t8. Onions")
                .addTopping("\t\t9. Peppers")
                .build();


        Pizza pizza4 = new PizzaBuilder()
                .setSize("Medium")
                .addTopping("\t\t1. Sausage")
                .addTopping("\t\t2. Bacon")
                .addTopping("\t\t3. Extra Cheese")
                .addTopping("\t\t4. Peppers")
                .addTopping("\t\t5. Olives")
                .addTopping("\t\t6. Spinach")
                .addTopping("\t\t7. Ham and Pineapple")
                .addTopping("\t\t8. Onions")
                .build();

        Pizza pizza5 = new PizzaBuilder()
                .setSize("Small")
                .addTopping("\t\t1. Pepperoni")
                .addTopping("\t\t2. Mushrooms")
                .addTopping("\t\t3. Onions")
                .addTopping("\t\t4. Ham")
                .addTopping("\t\t5. Pesto")
                .addTopping("\t\t6. Spicy Pork")
                .build();

        Pizza pizza6 = new PizzaBuilder()
                .setSize("Small")
                .addTopping("\t\t1. Pepperoni")
                .build();

        Pizza pizza7 = new PizzaBuilder()
                .setSize("Large")
                .addTopping("\t\t1. Chicken")
                .addTopping("\t\t2. Tomato and Basil")
                .addTopping("\t\t3. Beef")
                .build();


        pizza1.eat("Pizza Hut");
        System.out.println();
        pizza2.eat("Pizza Hut");
        System.out.println();


        pizza4.eat("Little Caesars");
        System.out.println();

        pizza5.eat("Little Caesars");
        System.out.println();

        pizza6.eat("Dominos");
        System.out.println();

        pizza7.eat("Dominos");
        System.out.println();




    }
}