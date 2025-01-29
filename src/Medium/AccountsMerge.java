package Medium;

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, ArrayList<HashSet<String>>> hm = new HashMap<>();
        for(List<String> li:accounts){
            String name = li.get(0);
            HashSet<String> emails = new HashSet<>(li);
            emails.remove(name);
            if(hm.containsKey(name)){
                ArrayList<HashSet<String>> emailsList = hm.get(name);
                HashSet<Integer> mergeIdx = new HashSet<>();
                for(int i=1; i<li.size(); i++){
                    String email = li.get(i);
                    for(int j=0; j<emailsList.size(); j++){
                        HashSet<String> hs = emailsList.get(j);
                        if(hs.contains(email)){
                            mergeIdx.add(j);
                        }
                    }
                }
                if(mergeIdx.size() == 0){
                    emailsList.add(emails);
                } else{
                    ArrayList<HashSet<String>> newLi = new ArrayList<>();
                    for(int i=0; i<emailsList.size(); i++){
                        if(mergeIdx.contains(i)){
                            emails.addAll(emailsList.get(i));
                        } else{
                            newLi.add(emailsList.get(i));
                        }
                    }
                    newLi.add(emails);
                    hm.put(name,newLi);
                }
            } else{
                ArrayList<HashSet<String>> tempHashList = new ArrayList<>();
                tempHashList.add(emails);
                hm.put(name,tempHashList);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(String name:hm.keySet()){
            for(HashSet<String> hs:hm.get(name)){
                ArrayList<String> emails = new ArrayList<>(hs);
                Collections.sort(emails);
                emails.add(0,name);
                ans.add(emails);
            }
        }
        return ans;
    }
}
