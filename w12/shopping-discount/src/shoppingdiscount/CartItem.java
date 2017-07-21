package shoppingdiscount;

public class CartItem {

    private final String name;
    private final double cost;

    public CartItem(String name, double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Negative cost");
        }
        this.name = name;
        this.cost = cost;
    }

    public boolean isShoe() {
        return name.equals("shoes");
    }

    public boolean isHat() {
        return name.equals("hat");
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem cartItem = (CartItem) o;

        if (Double.compare(cartItem.cost, cost) != 0) return false;
        return name != null ? name.equals(cartItem.name) : cartItem.name
                                                           == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "CartItem{" +
               "name='" + name + '\'' +
               ", cost=" + cost +
               '}';
    }
}
