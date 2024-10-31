package Hard;

import java.util.ArrayList;

public class OptimalAccountBalancing {
    public int minTransfers(int[][] tr) {
        int[] p = new int[12];
        for(int[] t:tr){
            int amount = t[2];
            p[t[0]] -= amount;
            p[t[1]] += amount;
        }
        int ans = 0;
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i:p){
            if(i != 0) nums.add(i);
        }
        int[] debt = new int[nums.size()];
        for(int i=0; i<debt.length; i++){
            debt[i] = nums.get(i);
        }
        return helper(debt,0);
    }

    private int helper(int[] debt, int idx){
        while(idx < debt.length && debt[idx] == 0) idx++;
        if(idx == debt.length) return 0;

        int min = Integer.MAX_VALUE;
        for(int j=idx+1; j<debt.length; j++){
            if(debt[j]*debt[idx] < 0){
                debt[j] += debt[idx];
                min = Math.min(min,helper(debt,idx+1)+1);
                debt[j] -= debt[idx];
            }
        }
        return min;
    }
}
