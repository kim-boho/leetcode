package Medium;

public class JumpGame5 {
    public boolean canReach(String s, int minJump, int maxJump) {
        int[] prefix = new int[s.length()];
        int reachedZeros = 0;
        if(maxJump == s.length() || s.charAt(s.length()-1) == '1') return false;
        else if(maxJump == s.length()-1) return true;

        prefix[minJump] = 1;
        prefix[maxJump+1] = -1;

        for(int i=minJump; i<s.length(); i++){
            reachedZeros += prefix[i];
            if(s.charAt(i) == '0' && reachedZeros > 0){
                if(i+minJump<s.length()) prefix[i+minJump]++;
                if(i+maxJump+1<s.length()) prefix[i+maxJump+1]--;
            }
        }

        return reachedZeros>0? true:false;
    }
}
