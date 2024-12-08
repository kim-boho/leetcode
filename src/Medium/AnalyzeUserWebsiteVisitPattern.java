package Medium;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern {
    int score = 0;
    HashMap<String, TreeMap<Integer,String>> hm;
    List<String> ans;
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        hm = new HashMap<>();
        HashSet<String> webs = new HashSet<>();
        for(int i=0; i<n; i++){
            String u = username[i];
            int time = timestamp[i];
            String web = website[i];
            TreeMap<Integer,String> tm;
            webs.add(web);
            if(hm.containsKey(u)) tm = hm.get(u);
            else tm = new TreeMap<>();
            tm.put(time,web);
            hm.put(u,tm);
        }
        String[] keys = new String[webs.size()];
        int i = 0;
        for(String k:webs){
            keys[i++] = k;
        }
        String[] temp = new String[3];
        dfs(keys,0,temp);
        return ans;
    }

    private void dfs(String[] keys, int count, String[] temp){
        if(count == 3){
            int newScore = checkScore(temp);
            if(newScore == 0) return;
            if(newScore > score){
                ans = new ArrayList<>();
                ans.add(temp[0]);
                ans.add(temp[1]);
                ans.add(temp[2]);
                score = newScore;
            } else if(newScore == score){
                if(ans == null || changeAns(temp)){
                    ans = new ArrayList<>();
                    ans.add(temp[0]);
                    ans.add(temp[1]);
                    ans.add(temp[2]);
                }
            }
            return;
        }
        for(int i=0; i<keys.length; i++){
            temp[count] = keys[i];
            dfs(keys,count+1,temp);
        }

    }

    private int checkScore(String[] temp){
        int ans = 0;
        for(String key:hm.keySet()){
            TreeMap<Integer,String> tm = hm.get(key);
            int i = 0;
            for(Integer time:tm.keySet()){
                String s = tm.get(time);
                if(temp[i].equals(s)) i++;
                if(i == 3) break;
            }
            if(i == 3) ans++;
        }
        return ans;
    }

    private boolean changeAns(String[] temp){
        for(int i=0; i<3; i++){
            String orig = ans.get(i);
            String newString = temp[i];
            int n = orig.compareTo(newString);
            if(n > 0) return true;
            else if(n < 0) return false;
            else continue;
        }
        return false;
    }
}
