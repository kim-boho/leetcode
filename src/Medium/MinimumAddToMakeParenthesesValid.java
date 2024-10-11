package Medium;

public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int left = 0;
        int invalid = 0;
        for(char c:s.toCharArray()){
            if(c == '(') left++;
            else{
                if(left == 0) invalid++;
                else left--;
            }
        }
        return invalid+left;
    }
}
