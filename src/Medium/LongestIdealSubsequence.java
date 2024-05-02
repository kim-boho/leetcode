package Medium;

public class LongestIdealSubsequence {
    public int longestIdealString(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] alphabets = new int[26];
        alphabets[arr[len-1]-'a'] = 1;
        int ans = 1;
        for(int i=len-2; i>=0; i--){
            int num = arr[i]-'a';
            int start = Math.max(num-k,0);
            int end = Math.min(25, num+k);
            int max = 0;
            for(int j=start; j<=end; j++){
                if(alphabets[j] > max) max = alphabets[j];
            }
            alphabets[num] = max+1;
            ans = Math.max(ans,alphabets[num]);
        }
        return ans;
    }
}
