package Easy;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] arr = new int[26];
        int[] arr2 = new int[26];

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isUpperCase(c)){
                arr2[c-'A']++;
            } else{
                arr[c-'a']++;
            }
        }

        int ans = 0;
        boolean midChar = false;
        for(int i=0; i<26; i++){
            if(arr[i] % 2 == 1){
                midChar = true;
                ans += arr[i];
                ans--;
            } else{
                ans += arr[i];
            }

            if(arr2[i] % 2 == 1){
                midChar = true;
                ans += arr2[i];
                ans--;
            } else{
                ans += arr2[i];
            }
            if(arr[i] == 1 || arr2[i] == 1) midChar = true;
        }

        return midChar? ans+1:ans;
    }
}
