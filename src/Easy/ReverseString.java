package Easy;

public class ReverseString {
    public void reverseString(char[] s) {
        for(int i=0; i<s.length/2; i++){
            if(s[s.length-1-i] != s[i]){
                char temp = s[i];
                s[i] = s[s.length-1-i];
                s[s.length-1-i] = temp;
            }
        }
    }
}
