package com.isha.prepare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Smoothie {
    static final String ORDER_DELIMITER = ",";
    static final String WHITE_SPACE = " ";
    static final String INGREDIENT_SPACE = ", ";
    static final String TRIM_SPACE_TO_EMPTY = ",";
    static final String APPEND_MENU_NAME = "_";
    static final String MINUS_INGREDIENT_OPERATOR = "-";




    public enum Menu {
        Classic("strawberry, banana, pineapple, mango, peach, honey"),
        Freezie("blackberry, blueberry, black currant, grape juice, frozen yogurt"),
        Greenie("green apple, lime, avocado, spinach, ice, apple juice"),
        Just_Desserts("banana, ice cream, chocolate, peanut, cherry");

        private String ingredients;

        Menu(String ingredients) {
            this.ingredients = ingredients;
        }

        public String getIngredients(){
            return ingredients;
        }

    }
    public static String ingredients(String order) {
        if(order == null || order.isEmpty()){
            throw new IllegalArgumentException();
        }
        String[] orderInput = order.split(ORDER_DELIMITER);
        if(orderInput.length == 0){
            throw new IllegalArgumentException();
        }
        String originalIngredient = Menu.valueOf((String)orderInput[0].replaceAll(WHITE_SPACE, APPEND_MENU_NAME)).getIngredients().replaceAll(INGREDIENT_SPACE, TRIM_SPACE_TO_EMPTY);
        List originalIngredients = new ArrayList(Arrays.asList(originalIngredient.split(ORDER_DELIMITER)));
        originalIngredients.sort(Comparator.naturalOrder());
        if(orderInput.length == 1){
            return String.join(ORDER_DELIMITER,originalIngredients);
        }
        for(int i = 1; i < orderInput.length; i++){
            String minusIngredient = orderInput[i].trim();
            if(!minusIngredient.substring(0,1).equals(MINUS_INGREDIENT_OPERATOR)){
                throw new IllegalArgumentException();
            }
            String removeIngredient = minusIngredient.substring(1).trim();
            originalIngredients.remove(removeIngredient);
        }
        return String.join(ORDER_DELIMITER,originalIngredients);
    }

    public static void main(String[] args){
        String ing = ingredients("Classic,-mango");
        System.out.println(ingredients("Classic,-"));
        System.out.println(ing);
        String ing2 = ingredients("Classic,-banana,-honey,-mango,-peach,-pineapple,-strawberry");
        System.out.println(ing2);
        //String ing3 = ingredients("-honey,-something");
        //System.out.println(ing3);
        String ing4 = ingredients("Just Desserts,-cherry");
        System.out.println(ing4);
    }
/*
        for(StayTime timeEntry : timeEntries){
            for(int i=0; i<k; i++){
                List<StayTime> currentBed = beds.get(i);
                if(currentBed.size() == 0){
                    currentBed.add(timeEntry);
                    noOfCheckins++;
                    break;
                }
                int lastOutTime = currentBed.get(currentBed.size()-1).getOutTime();
                int nextTimeIn = timeEntry.getInTime();
                if(nextTimeIn >= lastOutTime){
                    currentBed.add(timeEntry);
                    noOfCheckins++;
                    break;
                }
            }
        }*/

}
