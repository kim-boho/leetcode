package Easy;

public class MaximumOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        int ones = -1;
        char[] arr = s.toCharArray();
        for(char c:arr){
            if(c == '1') ones++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length-1; i++){
            if(ones > 0){
                sb.append("1");
                ones--;
            } else sb.append("0");
        }
        sb.append("1");
        return sb.toString();
    }
}
