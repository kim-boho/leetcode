package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        ArrayList<String> sts = new ArrayList<>(Arrays.asList(products));
        for(int i=0; i<searchWord.length(); i++){
            ArrayList<String> temp = new ArrayList<>();
            PriorityQueue<String> remains = new PriorityQueue<>();
            char c = searchWord.charAt(i);
            for(int j=0; j<sts.size(); j++){
                String s = sts.get(j);
                if(s.length()>i && s.charAt(i) == c){
                    temp.add(s);
                    remains.add(s.substring(i+1));
                }
            }
            String suffix = searchWord.substring(0,i+1);
            ArrayList<String> ans2 = new ArrayList<>();
            while(!remains.isEmpty() && ans2.size() < 3){
                String s = suffix+remains.poll();
                ans2.add(s);
            }
            ans.add(ans2);
            sts = temp;
        }
        return ans;
    }
}
