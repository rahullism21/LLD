package FoodOrderPricing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FoodOrderingService {

    private static final double Discount = 0.10;

    public  double calculateBill(List<Item> items){
         double total = items.stream()
                    .mapToDouble(i-> {if(i.getCategory().equalsIgnoreCase("Drink")){return i.getPrice()+20;} return i.getPrice();}).sum();

        if(total>1000){
            total=total -(total*Discount);
        }

        return total;
    }

    public Map<String, Double> categoryWiseTotal(List<Item> items){

        Map<String,Double>  categoryTotal = items.stream().
                                                collect(Collectors.groupingBy(Item::getCategory,Collectors.summingDouble(Item::getPrice)));

        return categoryTotal;

    }

    

 }
