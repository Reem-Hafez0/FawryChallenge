import java.util.*;

class Cart {
    //key->product  //value->quantity custom needed to buy
    private Map<Product, Integer> items = new HashMap<>();

    public void add(Product product, int qty) {
        if (product.isAvailable(qty)) {
            items.put(product, qty);
        } 
        else {
            System.out.println("Error: Not enough quantity for " + product.getName());
        }
    }

    public Map<Product, Integer> getItems() {
        return items;
    }
}