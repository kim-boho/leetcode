package Medium;

import java.util.ArrayList;
import java.util.List;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 1) return Integer.valueOf(tokens[0]);
        List<String> eqs = new ArrayList<>();
        int len = tokens.length;

        int idx = 0;
        while(idx<len){
            while(idx<tokens.length && !isOps(tokens[idx])) idx++;
            if(idx>=len) break;

            int numIdx1 = idx-1;
            while(numIdx1>=0 && tokens[numIdx1] == null) numIdx1--;
            int temp1 = Integer.valueOf(tokens[numIdx1]);

            int numIdx2 = numIdx1-1;
            while(numIdx2>=0 && tokens[numIdx2] == null) numIdx2--;
            int temp2 = Integer.valueOf(tokens[numIdx2]);

            int num = calculate(temp1, temp2, tokens[idx]);
            tokens[idx++] = String.valueOf(num);
            tokens[numIdx1] = null;
            tokens[numIdx2] = null;
        }

        return Integer.valueOf(tokens[len-1]);

    }

    private boolean isOps(String s){
        if(s.equals("*") || s.equals("+") || s.equals("/") || s.equals("-")) return true;
        else return false;
    }

    private int calculate(int num1, int num2, String operator){
        if(operator.equals("*")) return num1*num2;
        else if(operator.equals("/")) return num2/num1;
        else if(operator.equals("+")) return num1+num2;
        else return num2-num1;
    }
}
