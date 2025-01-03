package Medium;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] counts = new int[52];
        int distinctCount = 0;
        int i = 0;
        int j = 0;
        int ans = 0;
        char[] arr = s.toCharArray();
        while(i < s.length()){
            int c = arr[i];
            if(Character.isUpperCase(arr[i])){
                c -= 'A';
                c += 26;
            } else{
                c -= 'a';
            }
            counts[c]++;
            if(counts[c] == 1) distinctCount++;
            if(distinctCount > 2){
                while(distinctCount > 2 && j < i){
                    int c2 = arr[j];
                    if(Character.isUpperCase(arr[j])){
                        c2 -= 'A';
                        c2 += 26;
                    } else{
                        c2 -= 'a';
                    }
                    counts[c2]--;
                    if(counts[c2] == 0){
                        distinctCount--;
                    }
                    j++;
                }
                ans = Math.max(ans,i-j+1);
            } else ans = Math.max(ans,i-j+1);
            i++;
        }
        return ans;
    }
}
