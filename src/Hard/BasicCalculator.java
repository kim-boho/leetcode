package Hard;

import java.util.Stack;


public class BasicCalculator {
    public int calculate(String s) {
        char[] sChars = s.toCharArray();
        int currentNum = 0;
        int currentSum = 0;
        Stack<Integer> stack = new Stack<>();
        //1 = pos, -1 = neg
        int sign = 1;
        for(int i=0; i<sChars.length; i++){
            char currentChar = sChars[i];
            if(Character.isDigit(currentChar)){
                currentNum = currentNum*10+(currentChar-'0');
            } else if(currentChar == '+' || currentChar == '-'){
                currentSum += sign*currentNum;
                sign = currentChar == '+'? 1:-1;
                currentNum = 0;
            } else if(currentChar == '('){
                stack.add(currentSum);
                stack.add(sign);
                sign = 1;
                currentSum = 0;
            } else if(currentChar == ')'){
                currentSum += currentNum*sign;
                currentSum = currentSum*stack.pop()+stack.pop();
                currentNum = 0;
            }
        }
        currentSum += currentNum*sign;
        return currentSum;
    }
}
