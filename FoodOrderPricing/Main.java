package FoodOrderPricing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        FoodOrderingService fs= new FoodOrderingService();
        List<Item> items= new ArrayList<>();

        items.add(new Item("Briyani", 400D, "Food"));
        items.add(new Item("Coke", 1000D, "Drink"));
        items.add(new Item("Custurd", 60D, "Sweet"));

        double totalBill = fs.calculateBill(items);
        Map<String, Double> categorWise=  fs.categoryWiseTotal(items);

        System.out.println(totalBill);
        System.out.println(categorWise);
    }
}
