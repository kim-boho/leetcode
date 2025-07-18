package Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String,Double>> conversion = new HashMap();
        for(int i=0; i<values.length; i++){
            double val = values[i];
            List<String> e = equations.get(i);
            String x = e.get(0);
            String y = e.get(1);
            if(!conversion.containsKey(x)){
                HashMap<String,Double> temp = new HashMap();
                conversion.put(x,temp);
            }
            conversion.get(x).put(y,val);
            if(!conversion.containsKey(y)){
                HashMap<String,Double> temp = new HashMap();
                conversion.put(y,temp);
            }
            conversion.get(y).put(x,1/val);
        }
        double[] ans = new double[queries.size()];
        for(int i=0; i<ans.length; i++){
            List<String> q = queries.get(i);
            if(!conversion.containsKey(q.get(0)) || !conversion.containsKey(q.get(1))){
                ans[i] = -1;
                continue;
            }
            if(q.get(0).equals(q.get(1))){
                ans[i] = 1;
                continue;
            }
            HashSet<String> checkedVariables = new HashSet();
            checkedVariables.add(q.get(0));
            ans[i] = dfs(conversion, checkedVariables, q.get(0), q.get(1),1);
            checkedVariables.remove(q.get(0));
        }
        return ans;
    }

    private double dfs(HashMap<String, HashMap<String,Double>> conversion, HashSet<String> checkedVariables, String start, String target, double accumulated){
        HashMap<String,Double> edges = conversion.get(start);
        for(String key:edges.keySet()){
            if(!checkedVariables.contains(key)){
                if(target.equals(key)) return accumulated*edges.get(key);
                else{
                    checkedVariables.add(key);
                    double result = dfs(conversion,checkedVariables,key,target,accumulated*edges.get(key));
                    if(result != -1) return result;
                    checkedVariables.remove(key);
                }
            }
        }
        return -1;
    }
}
