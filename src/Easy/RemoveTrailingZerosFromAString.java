package Easy;

public class RemoveTrailingZerosFromAString {
    public String removeTrailingZeros(String num) {
        int i = num.length()-1;
        while(i >= 0 && num.charAt(i) == '0') i--;
        return i == -1? "":num.substring(0,i+1);
    }
}
