
import java.util.*;

// Abstract Product: Macronutrient
interface Macronutrient {
    String getName();
}

// Concrete Products
class Cheese implements Macronutrient {
    public String getName() {
        return "Cheese";
    }
}

class Bread implements Macronutrient {
    public String getName() {
        return "Bread";
    }
}

class Lentils implements Macronutrient {
    public String getName() {
        return "Lentils";
    }
}

class Pistachio implements Macronutrient {
    public String getName() {
        return "Pistachio";
    }
}

class Fish implements Macronutrient {
    public String getName() {
        return "Fish";
    }
}

class Chicken implements Macronutrient {
    public String getName() {
        return "Chicken";
    }
}

class Beef implements Macronutrient {
    public String getName() {
        return "Beef";
    }
}

class Tofu implements Macronutrient {
    public String getName() {
        return "Tofu";
    }
}

class Avocado implements Macronutrient {
    public String getName() {
        return "Avocado";
    }
}

class SourCream implements Macronutrient {
    public String getName() {
        return "Sour Cream";
    }
}

class Tuna implements Macronutrient {
    public String getName() {
        return "Tuna";
    }
}

class Peanuts implements Macronutrient {
    public String getName() {
        return "Peanuts";
    }
}

// Abstract Factory
interface MacronutrientFactory {
    Macronutrient createMacronutrient();
}

// Concrete Factories
class CarbsFactory implements MacronutrientFactory {
    private static CarbsFactory instance;

    private CarbsFactory() {}

    public static CarbsFactory getInstance() {
        if (instance == null) {
            instance = new CarbsFactory();
        }
        return instance;
    }

    public Macronutrient createMacronutrient() {
        Random rand = new Random();
        List<Macronutrient> carbsOptions = Arrays.asList(new Bread(), new Lentils(), new Pistachio());
        return carbsOptions.get(rand.nextInt(carbsOptions.size()));
    }
}

class ProteinFactory implements MacronutrientFactory {
    public static ProteinFactory instance;

    public ProteinFactory() {}

    public static ProteinFactory getInstance() {
        if (instance == null) {
            instance = new ProteinFactory();
        }
        return instance;
    }

    public Macronutrient createMacronutrient() {
        Random rand = new Random();
        List<Macronutrient> proteinOptions = Arrays.asList(new Fish(), new Chicken(), new Beef(), new Tofu());
        return proteinOptions.get(rand.nextInt(proteinOptions.size()));
    }
}

class FatsFactory implements MacronutrientFactory {
    public static FatsFactory instance;

    public FatsFactory() {}

    public static FatsFactory getInstance() {
        if (instance == null) {
            instance = new FatsFactory();
        }
        return instance;
    }

    public Macronutrient createMacronutrient() {
        Random rand = new Random();
        List<Macronutrient> fatsOptions = Arrays.asList(new Avocado(), new SourCream(), new Tuna(), new Peanuts());
        return fatsOptions.get(rand.nextInt(fatsOptions.size()));
    }
}

// Singleton Abstract Factory
class MealFactory {
    private static MealFactory instance;

    private MealFactory() {}

    public static MealFactory getInstance() {
        if (instance == null) {
            instance = new MealFactory();
        }
        return instance;
    }

    public Meal createMeal(String dietPlan) {
        MacronutrientFactory carbsFactory;
        MacronutrientFactory proteinFactory;
        MacronutrientFactory fatsFactory;

        if (dietPlan.equals("Paleo")) {
            carbsFactory = CarbsFactory.getInstance();
            proteinFactory = ProteinFactory.getInstance();
            fatsFactory = FatsFactory.getInstance();
        } else if (dietPlan.equals("Vegan")) {
            carbsFactory = CarbsFactory.getInstance();
            proteinFactory = new ProteinFactory() {
                public Macronutrient createMacronutrient() {
                    Random rand = new Random();
                    List<Macronutrient> veganProteinOptions = Arrays.asList(new Fish(), new Tofu());
                    return veganProteinOptions.get(rand.nextInt(veganProteinOptions.size()));
                }
            };
            fatsFactory = FatsFactory.getInstance();
        } else if (dietPlan.equals("Nut Allergy")) {
            carbsFactory = CarbsFactory.getInstance();
            proteinFactory = ProteinFactory.getInstance();
            fatsFactory = new FatsFactory() {
                public Macronutrient createMacronutrient() {
                    Random rand = new Random();
                    List<Macronutrient> noNutFatsOptions = Arrays.asList(new Avocado(), new SourCream(), new Tuna());
                    return noNutFatsOptions.get(rand.nextInt(noNutFatsOptions.size()));
                }
            };
        } else { // No Restriction
            carbsFactory = CarbsFactory.getInstance();
            proteinFactory = ProteinFactory.getInstance();
            fatsFactory = FatsFactory.getInstance();
        }

        Macronutrient carb = carbsFactory.createMacronutrient();
        Macronutrient protein = proteinFactory.createMacronutrient();
        Macronutrient fat = fatsFactory.createMacronutrient();

        return new Meal(carb, protein, fat);
    }
}

// Product: Meal
class Meal {
    private Macronutrient carb;
    private Macronutrient protein;
    private Macronutrient fat;

    public Meal(Macronutrient carb, Macronutrient protein, Macronutrient fat) {
        this.carb = carb;
        this.protein = protein;
        this.fat = fat;
    }

    public void display() {
        System.out.println("Carb: " + carb.getName());
        System.out.println("Protein: " + protein.getName());
        System.out.println("Fat: " + fat.getName());
        System.out.println();
    }
}

public class Prob2 {
    public static void main(String[] args) {
        // Create customers with different diet plans
        String[] dietPlans = {"No Restriction", "Paleo", "Vegan", "Nut Allergy"};
        String[] customerNames = {"Customer1", "Customer2", "Customer3", "Customer4", "Customer5", "Customer6"};

        // Generate meals for each customer
        for (int i = 0; i < 6; i++) {
            String dietPlan = dietPlans[i % dietPlans.length];
            String customerName = customerNames[i];
            MealFactory mealFactory = MealFactory.getInstance();
            Meal meal = mealFactory.createMeal(dietPlan);
            System.out.println(customerName + "'s Meal (Diet Plan: " + dietPlan + "):");
            meal.display();
        }
    }
}