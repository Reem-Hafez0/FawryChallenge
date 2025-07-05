import java.util.*;

class ShippingService {
    public static void ship(List<Shippable> items) {
        System.out.println("\n** Shipment notice **");
        double totalWeight = 0;
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Double> weightMap = new HashMap<>();

        for (Shippable item : items) {
            countMap.put(item.getName(), countMap.getOrDefault(item.getName(), 0) + 1);
            weightMap.put(item.getName(), item.getWeight());
            totalWeight += item.getWeight();
        }

        for (String name : countMap.keySet()) {
            System.out.println(countMap.get(name) + "x " + name + "\t" + weightMap.get(name) + "g");
        }

        System.out.println("Total package weight " + (totalWeight / 1000.0) + "kg");
    }
}