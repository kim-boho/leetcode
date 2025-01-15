package Medium;

public class FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        int zeroes = 0;
        char[] arr = s.toCharArray();
        for(char c:arr){
            if(c == '0') zeroes++;
        }
        int ans = arr.length-zeroes;
        int ones = 0;
        for(int i=0; i<arr.length; i++){
            ans = Math.min(ans,zeroes+ones);
            if(arr[i] == '0'){
                zeroes--;
            } else ones++;
        }
        return ans;
    }
}
