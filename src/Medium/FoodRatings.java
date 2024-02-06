package Medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class FoodRatings {
    HashMap<String, Integer> rates = new HashMap();
    HashMap<String, String> foodCuis = new HashMap();
    HashMap<String, TreeMap<Integer, TreeSet<String>>> cuis = new HashMap();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i=0; i<foods.length; i++){
            String c = cuisines[i];
            int r = ratings[i];
            String f = foods[i];
            rates.put(f,r);
            foodCuis.put(f,c);
            if(cuis.containsKey(c)){
                if(cuis.get(c).containsKey(r)){
                    cuis.get(c).get(r).add(f);
                } else{
                    TreeSet<String> temp = new TreeSet();
                    temp.add(f);
                    cuis.get(c).put(r,temp);
                }
            } else{
                TreeMap<Integer, TreeSet<String>> temp = new TreeMap(Collections.reverseOrder());
                TreeSet<String> temp2 = new TreeSet();
                temp2.add(f);
                temp.put(r,temp2);
                cuis.put(c,temp);
            }
        }
    }

    public void changeRating(String food, int newRating) {
        if(rates.get(food) != newRating){
            int prev = rates.get(food);
            rates.put(food, newRating);
            String c = foodCuis.get(food);
            if(cuis.get(c).containsKey(newRating)){
                cuis.get(c).get(newRating).add(food);
            } else{
                TreeSet<String> temp = new TreeSet();
                temp.add(food);
                cuis.get(c).put(newRating,temp);
            }
            if(cuis.get(foodCuis.get(food)).get(prev).size() == 1){
                cuis.get(foodCuis.get(food)).remove(prev);
            } else{
                cuis.get(foodCuis.get(food)).get(prev).remove(food);
            }
            rates.put(food, newRating);
        }
    }

    public String highestRated(String cuisine) {
        for(Integer i: cuis.get(cuisine).keySet()){
            for(String s: cuis.get(cuisine).get(i)){
                return s;
            }
        }
        return null;
    }
}

