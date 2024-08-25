package Medium;

import java.util.ArrayList;

public class FractionAdditionAndSubtraction {
    public String fractionAddition(String s) {
        String[] arr = s.split("[-+]");
        ArrayList<Character> li = new ArrayList<>();
        if(s.charAt(0) != '-') li.add('+');
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='-' || c=='+') li.add(c);
        }
        int i = 0;
        if(arr[0] == "") i++;
        ArrayList<Integer> numes = new ArrayList<>();
        int j = 0;
        for(; i<arr.length; i++){
            String frac = arr[i];
            String[] nums = frac.split("/");
            int times = 2520/Integer.valueOf(nums[1]);
            int nume = times*Integer.valueOf(nums[0]);
            if(li.get(j++) == '-') nume *= -1;
            numes.add(nume);
        }
        long total = 0;
        for(int n:numes){
            total += n;
        }
        if(total == 0) return "0/1";
        else{
            int deno = 2520;
            long gcd = getGCD(Math.abs(total),deno);
            total /= gcd;
            deno /= gcd;
            return total+"/"+deno;
        }
    }

    public static long getGCD(long num1, long num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1%num2);
    }
}
