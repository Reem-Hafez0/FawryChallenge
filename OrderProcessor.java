import java.util.*;

class OrderProcessor {
    public static void checkout(Customer customer, Cart cart) {
        //from cart class
        Map<Product, Integer> items = cart.getItems();

        if (items.isEmpty()) {
            System.out.println("Error: Cart is empty");
            return;
        }

        double subtotal = 0;
        double shippingFees = 0;
        List<Shippable> toShip = new ArrayList<>(); //array for shippable products

        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();

            if (p.isExpirable() && p.isExpired()) {
                System.out.println("Error: " + p.getName() + " is expired.");
                return;
            }

            if (!p.isAvailable(qty)) {
                System.out.println("Error: Not enough stock for " + p.getName());
                return;
            }

            subtotal += p.getPrice() * qty;

            if (p.isShippable()) {
                for (int i = 0; i < qty; i++) {
                    toShip.add(p);
                    shippingFees += 15; 
                }
            }
        }

        double total = subtotal + shippingFees;

        if (!customer.canPay(total)) {
            System.out.println("Error: Not enough balance");
            return;
        }

        customer.pay(total);

        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            entry.getKey().reduceQuantity(entry.getValue());
        }

        if (!toShip.isEmpty()) {
            ShippingService.ship(toShip);
        }

        System.out.println("\n** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            System.out.println(qty + "x " + p.getName() + "\t" + (p.getPrice() * qty));
        }
        System.out.println("----------------------");
        System.out.println("Subtotal\t\t" + subtotal);
        System.out.println("Shipping\t\t" + shippingFees);
        System.out.println("Amount\t\t" + total);
        System.out.println("Remaining Balance\t" + customer.getBalance());
    }
}
