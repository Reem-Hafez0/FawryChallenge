import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Reem", 1000);

        Product cheese = new Product("Cheese", 100, 5, true, LocalDate.of(2025, 8, 1), true, 200);
        Product tv = new Product("TV", 500, 2, false, null, true, 7000);
        Product biscuits = new Product("Biscuits", 150, 3, true, LocalDate.of(2025, 7, 10), true, 700);
        Product scratchCard = new Product("Scratch Card", 50, 10, false, null, false, 0);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);
        cart.add(tv, 3);

        OrderProcessor.checkout(customer, cart);
    }
}