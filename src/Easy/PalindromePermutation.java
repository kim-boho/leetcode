package Easy;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        char[] chars = new char[26];
        int odd = 0;
        for(char c:s.toCharArray()){
            chars[c-'a']++;
            if(chars[c-'a']%2 == 1){
                odd++;
            } else{
                if(odd != 0) odd--;
            }
        }
        return odd <= 1;
    }
}
