package Easy;

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        int leftPar = 0;
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            if(leftPar == 0){
                leftPar++;
            } else{
                if(c == ')'){
                    if(leftPar != 1) sb.append(')');
                    leftPar--;
                } else{
                    leftPar++;
                    sb.append('(');
                }
            }
        }
        return sb.toString();
    }
}
