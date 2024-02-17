package Easy;

public class FindFirstPalindromicStringInTheArray {
    public String firstPalindrome(String[] words) {
        for(String s:words){
            if(isPalindromic(s)) return s;
        }
        return "";
    }

    private boolean isPalindromic(String s){
        int i = 0;
        int j = s.length()-1;
        char[] arr = s.toCharArray();
        while(i < j){
            if(arr[i] != arr[j]) return false;
            i++; j--;
        }
        return true;
    }
}
