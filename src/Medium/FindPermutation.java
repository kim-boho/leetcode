package Medium;

public class FindPermutation {
    public int[] findPermutation(String s) {
        int[] ans = new int[s.length()+1];
        ans[0] = 1;
        char[] charArr = s.toCharArray();
        int sArrIdx = 0;
        int possibleNum = 2;
        while(sArrIdx < charArr.length){
            char c = charArr[sArrIdx];
            if(c == 'I'){
                int startNum = Math.max(ans[sArrIdx]+1,possibleNum);
                while(sArrIdx < charArr.length && charArr[sArrIdx] == c){
                    ans[sArrIdx+1] = startNum++;
                    sArrIdx++;
                }
                possibleNum = startNum;
            } else{
                int startNum = ans[sArrIdx];
                int j = sArrIdx;
                while(sArrIdx < charArr.length && charArr[sArrIdx] == c) sArrIdx++;
                for(int k=sArrIdx; k>=j; k--){
                    ans[k] = startNum++;
                }
                possibleNum = startNum;
            }
        }
        return ans;
    }
}
