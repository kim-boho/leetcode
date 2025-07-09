package Medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] lastIdx = new int[26];
        char[] arr = s.toCharArray();
        for(int i=arr.length-1; i>=0; i--){
            if(lastIdx[arr[i]-'a'] == 0){
                lastIdx[arr[i]-'a'] = i;
            }
        }
        int i = 0;
        List<Integer> ans = new ArrayList<>();
        while(i < arr.length){
            int last = lastIdx[arr[i]-'a'];
            int j = i+1;
            while(j < last){
                last = Math.max(last,lastIdx[arr[j]-'a']);
                j++;
            }
            ans.add(last-i+1);
            i = last+1;
        }
        return ans;
    }
}
