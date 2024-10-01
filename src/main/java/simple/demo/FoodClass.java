package simple.demo;

import java.util.Map;

public class FoodClass {
    private Map<String, Map<String, Integer>> fruits;
    private Map<String, Map<String, Integer>> vegetables;

    public Map<String, Map<String, Integer>> getFruits() {
        return fruits;
    }

    public void setFruits(Map<String, Map<String, Integer>> fruits) {
        this.fruits = fruits;
    }

    public Map<String, Map<String, Integer>> getVegetables() {
        return vegetables;
    }

    public void setVegetables(Map<String, Map<String, Integer>> vegetables) {
        this.vegetables = vegetables;
    }
    

    public static void printFormattedData(FoodClass foodData) {

        System.out.println("fruits");
        printCategory(foodData.getFruits());


        System.out.println("vegetables");
        printCategory(foodData.getVegetables());
    }


    private static void printCategory(Map<String, Map<String, Integer>> category) {
        for (Map.Entry<String, Map<String, Integer>> entry : category.entrySet()) {
            String itemName = entry.getKey(); 
            Map<String, Integer> types = entry.getValue(); 

            System.out.println(".. " + itemName); 

            for (Map.Entry<String, Integer> typeEntry : types.entrySet()) {
                System.out.println(".... " + typeEntry.getKey()); 
            }
        }
    }
    
    public static void printOverallMax(FoodClass foodData) {
        int overallMaxQuantity = Integer.MIN_VALUE; 
        String maxItem = ""; 
        String maxType = ""; 

        for (Map.Entry<String, Map<String, Integer>> entry : foodData.getFruits().entrySet()) {
            String itemName = entry.getKey();
            Map<String, Integer> types = entry.getValue();

            for (Map.Entry<String, Integer> typeEntry : types.entrySet()) {
                int quantity = typeEntry.getValue();
                if (quantity > overallMaxQuantity) {
                    overallMaxQuantity = quantity;
                    maxItem = itemName;
                    maxType = typeEntry.getKey();
                }
            }
        }

        for (Map.Entry<String, Map<String, Integer>> entry : foodData.getVegetables().entrySet()) {
            String itemName = entry.getKey();
            Map<String, Integer> types = entry.getValue();

            for (Map.Entry<String, Integer> typeEntry : types.entrySet()) {
                int quantity = typeEntry.getValue();
                if (quantity > overallMaxQuantity) {
                    overallMaxQuantity = quantity;
                    maxItem = itemName;
                    maxType = typeEntry.getKey();
                }
            }
        }

        if (overallMaxQuantity != Integer.MIN_VALUE) {
            System.out.println("Maximum quantity: " + overallMaxQuantity + " (" + maxItem + ", " + maxType + ")");
        } else {
            System.out.println("No quantities found.");
        }
    }

}
