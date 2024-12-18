package Easy;

public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                if(i+1 == j) return true;
                else{
                    String temp = s.substring(0,i)+s.substring(i+1,s.length());
                    if(isPal(temp)) return true;
                    temp = s.substring(0,j)+s.substring(j+1,s.length());
                    return isPal(temp);
                }
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPal(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
