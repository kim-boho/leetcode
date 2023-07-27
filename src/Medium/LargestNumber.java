package Medium;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2){
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s2.compareTo(s1);
            }
        });
        String ans = "";
        for(String st:str) ans += st;
        if(ans.charAt(0) == '0') return "0";
        return ans;
    }
}
