package Medium;

import java.util.Arrays;

public class MaximumSwap {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        char[] cArr = s.toCharArray();
        int[] digits = new int[10];
        Arrays.fill(digits,-1);
        for(int i=cArr.length-1; i>=0; i--){
            if(digits[cArr[i]-'0'] == -1) digits[cArr[i]-'0'] = i;
        }
        boolean isDone = false;
        for(int i=0; !isDone && i<cArr.length; i++){
            char c = cArr[i];
            for(int j=9; !isDone && j>c-'0'; j--){
                if(digits[j] != -1 && digits[j] > i){
                    char temp = cArr[i];
                    cArr[i] = cArr[digits[j]];
                    cArr[digits[j]] = temp;
                    isDone = true;;
                }
            }
        }
        int ans = 0;
        for(int i=0; i<cArr.length; i++){
            ans *= 10;
            ans += (int)(cArr[i]-'0');
        }
        return ans;
    }
}
