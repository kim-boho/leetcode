package Medium;

public class CountNumberOfHomogenousSubstrings {
    public int countHomogenous(String s) {
        long mod = 1000000007;
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        char prev = chars[0];
        int i = 1;
        long count = 1;
        long ans = 0;
        while(i < chars.length){
            if(prev == chars[i]){
                count++;
            } else{
                ans += ((count+1)*(count)/2)%mod;
                ans %= mod;
                prev = chars[i];
                count = 1;
            }
            i++;
        }
        ans += ((count+1)*(count)/2)%mod;
        ans %= mod;
        return (int)ans;
    }
}
