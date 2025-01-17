package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class InvalidTransactions {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new ArrayList<>();
        HashMap<String, ArrayList<int[]>> hm = new HashMap<>();
        HashMap<String,Integer> cities = new HashMap<>();
        int idx = 0;
        for(int i=0; i<transactions.length; i++){
            String s = transactions[i];
            String[] arr = s.split(",");
            int[] arr2 = new int[4];
            arr2[0] = Integer.parseInt(arr[1]);
            if(!cities.containsKey(arr[3])) cities.put(arr[3],idx++);
            arr2[1] = cities.get(arr[3]);
            arr2[2] = i;
            arr2[3] = Integer.parseInt(arr[2]);
            ArrayList<int[]> li;
            if(hm.containsKey(arr[0])){
                li = hm.get(arr[0]);
            } else{
                li = new ArrayList<>();
                hm.put(arr[0],li);
            }
            li.add(arr2);
        }
        for(String name:hm.keySet()){
            ArrayList<int[]> li = hm.get(name);
            Collections.sort(li,(a, b) -> a[0]-b[0]);
            boolean[] check = new boolean[li.size()];
            for(int i=0; i<li.size(); i++){
                if(check[i]) continue;
                if(li.get(i)[3] > 1000){
                    check[i] = true;
                    continue;
                }
                int time = li.get(i)[0];
                int city = li.get(i)[1];
                for(int j=i-1; j>=0 && li.get(j)[0] >= time-60 && !check[i]; j--){
                    if(city != li.get(j)[1]){
                        check[i] = true;
                        check[j] = true;
                        break;
                    }
                }
                for(int j=i+1; j<li.size() && li.get(j)[0] <= time+60 && !check[i]; j++){
                    if(city != li.get(j)[1]){
                        check[i] = true;
                        check[j] = true;
                        break;
                    }
                }
            }
            for(int i=0; i<check.length; i++){
                if(check[i]) ans.add(transactions[li.get(i)[2]]);
            }
        }
        return ans;
    }
}
