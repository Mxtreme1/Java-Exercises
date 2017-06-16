package food;

import java.util.Map;

public class Meal {
    /**
     * Implementation of whole meals composed by instances of Food
     */
    private String meal_Name;
    private Map<Food, Double> map;
    private double calories;
    public Meal(String name, Map<Food, Double> ingredients) {
        //Constructor of Meal
        this.meal_Name = name;
        this.map = ingredients;
    }
    public String getName() {
        return this.meal_Name;
    }
    public Map<Food, Double> getIngredients() {
        return this.map;
    }
    public double getCalorificValue() {
        //Iterates over all Foods in the Meal and sums up their relative energy density to get the calorific value
        this.calories = 0;
        for (Map.Entry<Food, Double> entry : this.map.entrySet()) {
            calories += entry.getKey().relativeEnergyDensity() * entry.getValue();
        }
        return calories;
    }
}
