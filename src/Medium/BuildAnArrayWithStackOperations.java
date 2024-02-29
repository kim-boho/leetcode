package Medium;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList();
        int count = 0;
        for(int i=1; i<=n; i++){
            int temp = 0;
            while(count < target.length && i < n && target[count] > i){
                ans.add("Push");
                temp++;
                i++;
            }
            for(int j=0; j<temp; j++) ans.add("Pop");
            ans.add("Push");
            count++;
            if(count == target.length) break;
        }
        return ans;
    }
}
