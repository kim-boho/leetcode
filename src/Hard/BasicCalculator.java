package Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicCalculator {
    public int calculate(String s) {
        s = s.replace(" ","");
        List<String> splittedExpression = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\d+|[+\\-()]{1}");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            splittedExpression.add(matcher.group());
        }
        int[] ansArr = calculateWithParentheses(0,splittedExpression);
        return ansArr[0];
    }

    private int[] calculateWithParentheses(int startParenthesesIdex, List<String> splittedExpression){
        int[] sumAndParenthesesEndIndes = new int[]{0,-1};
        boolean isAddOperation = true;
        for(int i=startParenthesesIdex; i<splittedExpression.size(); i++){
            String s = splittedExpression.get(i);
            if(s.equals("(")){
                int[] subExp = calculateWithParentheses(i+1,splittedExpression);
                i = subExp[1];
                if(isAddOperation) sumAndParenthesesEndIndes[0] += subExp[0];
                else sumAndParenthesesEndIndes[0] -= subExp[0];
            } else if(s.equals(")")){
                sumAndParenthesesEndIndes[1] = i;
                break;
            } else if(s.equals("+")){
                isAddOperation = true;
            } else if(s.equals("-")){
                isAddOperation = false;
            } else{
                int currentNum = Integer.parseInt(s);
                if(isAddOperation) sumAndParenthesesEndIndes[0] += currentNum;
                else sumAndParenthesesEndIndes[0] -= currentNum;
            }
        }
        return sumAndParenthesesEndIndes;
    }
}
