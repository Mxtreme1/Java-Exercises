package food;

public class Food {
    private String food_Name;
    private double carbs;
    private double fats;
    private double protein;
    public Food (String name, double carbohydrateShare, double fatShare, double proteinShare) {
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
        return (this.carbs + this.protein) * 17 + this.fats * 37;
    }
    @Override public boolean equals(Object r) {
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
