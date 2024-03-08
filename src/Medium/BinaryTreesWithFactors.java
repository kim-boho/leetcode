package Medium;

import java.util.Arrays;
import java.util.HashMap;

public class BinaryTreesWithFactors {
    public int numFactoredBinaryTrees(int[] arr) {
        int ans = 0;
        Arrays.sort(arr);
        HashMap<Integer, Long> hm = new HashMap();

        for(int i=0; i<arr.length; i++){
            int n = arr[i];
            long total = 1;
            for(int j=0; j<i; j++){
                if(arr[j]*arr[j] == n){
                    total = total+((long)(hm.get(arr[j])*hm.get(arr[j]))%1000000007);
                    total = total%1000000007;
                }
                else if(n % arr[j] == 0 && hm.containsKey(n/arr[j])){
                    total = total+((long)(hm.get(n/arr[j])*hm.get(arr[j]))%1000000007);
                    total = total%1000000007;
                }
            }
            hm.put(n,total);
            ans = (ans+(int)total)%1000000007;
        }
        return ans;
    }
}
