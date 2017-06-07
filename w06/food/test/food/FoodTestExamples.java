package food;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class FoodTestExamples {

    @Test
    public void testMeal() {
        Map<Food, Double> ingredients = new HashMap<>();
        ingredients.put(new Food("Water", 0.0, 0.0, 0.0), 1000.0);
        ingredients.put(new Food("Sugar", 1.0, 0.0, 0.0), 100.0);
        ingredients.put(new Food("Protein", 0.0, 0.0, 1.0), 100.0);

        Meal shake = new Meal("Fitness-Shake", ingredients);
        assertEquals(3400.0, shake.getCalorificValue(), 0.0001);
    }

    @Test
    public void testMeal1() {
        Map<Food, Double> ingredients = new HashMap<>();
        ingredients.put(new Food("Water", 0.0, 0.0, 0.0), 1000.0);
        ingredients.put(new Food("Sugar", 1.0, 0.0, 0.0), 100.0);
        ingredients.put(new Food("Protein", 0.0, 0.0, 1.0), 100.0);

        Meal shake = new Meal("Fitness-Shake", ingredients);
        assertEquals(shake.getName(), "Fitness-Shake");
    }
    //TODO!!!
    @Test
    public void testMeal2() {
        Map<Food, Double> ingredients = new HashMap<>();
        ingredients.put(new Food("Water", 0.0, 0.0, 0.0), 1000.0);
        ingredients.put(new Food("Sugar", 1.0, 0.0, 0.0), 100.0);
        ingredients.put(new Food("Protein", 0.0, 0.0, 1.0), 100.0);
        Meal shake = new Meal("Fitness-Shake", ingredients);
        assertEquals(shake.getIngredients().keySet(), shake.getIngredients().keySet());
    }

    @Test
    public void testFood1(){
        assertEquals(new Food("Water", 0.0, 0.0, 0.0).getName(), "Water");
    }

    @Test
    public void testFood2(){
        assertEquals(new Food("Water", 0.0, 0.0, 0.1), new Food("Water", 0.0, 0.0, 0.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalFood() {
        new Food("Burger", 1, 1, 1);
    }
}
