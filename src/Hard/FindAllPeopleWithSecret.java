package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindAllPeopleWithSecret {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Integer> ans = new ArrayList<>();
        boolean[] secrets = new boolean[n];
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));
        secrets[firstPerson] = true;
        secrets[0] = true;
        for(int i=0; i<meetings.length; i++){
            if(i+1<meetings.length && meetings[i][2] == meetings[i+1][2]){
                ArrayList<int[]> li = new ArrayList<>();
                int time = meetings[i][2];
                while(i<meetings.length && meetings[i][2] == time){
                    if(secrets[meetings[i][0]]) secrets[meetings[i][1]] = true;
                    else if(secrets[meetings[i][1]]) secrets[meetings[i][0]] = true;
                    else li.add(meetings[i]);
                    i++;
                }
                i--;
                while(!li.isEmpty()){
                    boolean modified = false;
                    for(int j=0; j<li.size(); j++){
                        if(secrets[li.get(j)[0]] || secrets[li.get(j)[1]]){
                            secrets[li.get(j)[0]] = true;
                            secrets[li.get(j)[1]] = true;
                            modified = true;
                            li.remove(j);
                        }
                    }
                    if(!modified) break;
                }
            } else{
                int p1 = meetings[i][0];
                int p2 = meetings[i][1];
                if(secrets[p1]) secrets[p2] = true;
                else if(secrets[p2]) secrets[p1] = true;
            }
        }
        for(int i=0; i<n; i++){
            if(secrets[i]) ans.add(i);
        }
        return ans;
    }
}
