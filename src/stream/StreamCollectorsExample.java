package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectorsExample {

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );

        Map<Object, List<Order>> groupedByProducts = orders.stream().collect(Collectors.groupingBy(Order::getProduct));
        for (Map.Entry<Object, List<Order>> map: groupedByProducts.entrySet()) {
            List<Order> list = map.getValue();
            System.out.println("Key is : " + map.getKey());
            for (Order order: list) {
                System.out.println("Order is: " + order);
            }
        }

        Map<String, Double> sumOfOrdersForDistinct = orders.stream().collect(Collectors.groupingBy(Order::getProduct,
                Collectors.summingDouble(Order::getCost)));
        for (Map.Entry<String, Double> entry: sumOfOrdersForDistinct.entrySet()) {
            System.out.println("Key is: " + entry.getKey() + " and value is " + entry.getValue());
        }

        List<Order> sortedDesc = orders.stream().sorted(Comparator.comparing(Order::getCost).reversed()).toList();
        for (Order order: sortedDesc) {
            System.out.println(order.getProduct() + " : " + order.getCost());
        }

        List<Order> threeTheMostExpensive = orders.stream().sorted(Comparator.comparing(Order::getCost)
                .reversed()).limit(3).toList();
        for (Order order: threeTheMostExpensive) {
            System.out.println(order.getProduct());
        }

        Double totalSum = orders.stream().sorted(Comparator.comparing(Order::getCost)
                .reversed()).limit(3).mapToDouble(Order::getCost).sum();
        System.out.println(totalSum);
    }
}
