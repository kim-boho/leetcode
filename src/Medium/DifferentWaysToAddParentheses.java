package Medium;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList();
        if(expression.length()<=2){
            ans.add(Integer.valueOf(expression));
            return ans;
        }
        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);
            if(c == '*' | c == '-' | c == '+'){
                List<Integer> leftAns = diffWaysToCompute(expression.substring(0,i));
                List<Integer> rightAns = diffWaysToCompute(expression.substring(i+1,expression.length()));
                for(int j : leftAns){
                    for(int k : rightAns){
                        if(c == '*'){
                            ans.add(j*k);
                        } else if(c == '-'){
                            ans.add(j-k);
                        } else if(c == '+'){
                            ans.add(j+k);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
