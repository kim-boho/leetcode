package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindAllPossibleRecipesFromGivenSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String,List<String>> recs = new HashMap<>();
        HashSet<String> supls = new HashSet<>();
        for(String s:supplies) supls.add(s);
        for(int i=0; i<recipes.length; i++){
            ingredients.get(i).add("N");
            recs.put(recipes[i],ingredients.get(i));
        }
        List<String> ans = new ArrayList<>();
        for(String s:recipes){
            HashSet<String> preq = new HashSet<>();
            if(findRecipes(preq,s,recs,ingredients,supls)) ans.add(s);
        }
        return ans;
    }

    private boolean findRecipes(HashSet<String> preq, String target, HashMap<String,List<String>> recs, List<List<String>> in, HashSet<String> supls){
        List<String> ingres = recs.get(target);
        String flag = ingres.get(ingres.size()-1);
        if(flag.equals("T")) return true;
        else if(flag.equals("F")) return false;
        else{
            for(int i=0; i<ingres.size()-1; i++){
                String s = ingres.get(i);
                if(supls.contains(s)) continue;
                else if(recs.containsKey(s)){
                    if(preq.contains(s)){
                        ingres.set(ingres.size()-1,"F");
                        return false;
                    }
                    preq.add(s);
                    if(!findRecipes(preq,s,recs,in,supls)){
                        ingres.set(ingres.size()-1,"F");
                        return false;
                    }
                    preq.remove(s);
                } else{
                    ingres.set(ingres.size()-1,"F");
                    return false;
                }
            }
            ingres.set(ingres.size()-1,"T");
            return true;
        }
    }
}
