package Easy;

public class MaximumNestingDepthOfTheParentheses {
    public int maxDepth(String s) {
        int left = 0;
        int ans = 0;
        char[] arr = s.toCharArray();
        for(char c:arr){
            if(c=='(') left++;
            else if(c==')') left--;
            ans = Math.max(left, ans);
        }
        return ans;
    }
}
