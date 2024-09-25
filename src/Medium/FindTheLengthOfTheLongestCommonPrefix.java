package Medium;

import java.util.HashSet;

public class FindTheLengthOfTheLongestCommonPrefix {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> hs = new HashSet<>();
        int max = 0;
        for(int n:arr1){
            while(n > 0){
                hs.add(n);
                n /= 10;
            }
        }
        for(int n:arr2){
            while(n > 0){
                if(hs.contains(n)){
                    max = Math.max(max,n);
                    break;
                }
                n /= 10;
            }
        }
        return max == 0? 0:String.valueOf(max).length();
    }
}
