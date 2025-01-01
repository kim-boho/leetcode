package Easy;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        int left = 0;
        int right = s.length()-1;
        StringBuilder sb = new StringBuilder();
        while(left < s.length()){
            if(Character.isLetter(s.charAt(left))){
                while(!Character.isLetter(s.charAt(right))) right--;
                sb.append(s.charAt(right));
                right--;
            } else sb.append(s.charAt(left));
            left++;
        }
        return sb.toString();
    }
}
