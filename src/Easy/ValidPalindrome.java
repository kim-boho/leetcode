package Easy;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            while(start<s.length()){
                char c = s.charAt(start);
                if(Character.isDigit(c) || Character.isAlphabetic(c)) break;
                start++;
            }
            while(end>=0){
                char c = s.charAt(end);
                if(Character.isDigit(c) || Character.isAlphabetic(c)) break;
                end--;
            }
            if(start<s.length() && end>=0 && Character.toLowerCase(s.charAt(start++)) != Character.toLowerCase(s.charAt(end--))) return false;
        }
        return true;
    }
}
