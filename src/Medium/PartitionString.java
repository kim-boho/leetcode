package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PartitionString {
    public List<String> partitionString(String s) {
        char[] arr = s.toCharArray();
        int idx = 0;
        HashSet<String> checked = new HashSet<>();
        List<String> ans = new ArrayList<>();
        StringBuilder segment = new StringBuilder();
        while(idx < arr.length){
            segment.append(arr[idx]);
            String str = segment.toString();
            if(!checked.contains(str)){
                ans.add(str);
                checked.add(str);
                segment = new StringBuilder();
            }
            idx++;
        }
        return ans;
    }
}
