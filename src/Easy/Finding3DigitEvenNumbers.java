package Easy;

import java.util.ArrayList;

public class Finding3DigitEvenNumbers {
    ArrayList<Integer> li;
    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for(int i:digits) count[i]++;
        int[] tempArr = new int[3];
        li = new ArrayList();
        helper(0,count,tempArr);
        int[] ans = new int[li.size()];
        for(int i=0; i<ans.length; i++){
            ans[i] = li.get(i);
        }
        return ans;
    }

    private void helper(int idx, int[] count, int[] tempArr){
        if(idx > 2){
            li.add(tempArr[0]*100+tempArr[1]*10+tempArr[2]);
            return;
        }
        for(int i=0; i<count.length; i++){
            if(idx == 0 && i == 0) continue;
            if(idx == 2 && i % 2 == 1) continue;
            if(count[i] != 0){
                count[i]--;
                tempArr[idx] = i;
                helper(idx+1,count,tempArr);
                count[i]++;
            }
        }
    }
}
