package food;

public class Food {
    /**
     * Implementation of Foods
     * Foods are defined by their name share of carbs, fats and proteins in percent
     */
    private String food_Name;
    private double carbs;
    private double fats;
    private double protein;
    public Food (String name, double carbohydrateShare, double fatShare, double proteinShare) {
        //Constructor of Food checks also if the percentages are bigger than 100%
        this.food_Name = name;
        this.carbs = carbohydrateShare;
        this.fats = fatShare;
        this.protein = proteinShare;
        if (this.carbs + this.fats + proteinShare > 1 || this.carbs < 0 || this.fats < 0 || this.protein < 0) {
           throw new IllegalArgumentException(); 
        }
    }
    public String getName() {
        return this.food_Name;
    }
    public double relativeEnergyDensity() {
        //Returns relative Energy density using european standards
        return (this.carbs + this.protein) * 17 + this.fats * 37;
    }
    @Override public boolean equals(Object r) {
        //Two foods are equal when their names are equal
        if (this == r) {
            return true;
        }
        Food rfood = (Food)r;
        if (rfood.getName().equals(this.getName())) {
            return true;
        }
        return false;

    }
    @Override public int hashCode() {
       return this.getName().hashCode();

    }
}
