package Medium;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    ArrayList<List<Integer>> result = new ArrayList();
    int[] tempPermus;
    boolean[] checked;
    int depth;
    public List<List<Integer>> permute(int[] nums) {
        int count = 0;
        depth = nums.length;
        tempPermus = new int[depth];
        checked = new boolean[depth];
        dfs(count, nums);
        return result;
    }
    public void dfs(int count, int[] nums){
        if(count == depth){
            ArrayList<Integer> temp = new ArrayList();
            for(int i:tempPermus) temp.add(i);
            result.add(temp);
        } else{
            for(int i=0; i<depth; i++){
                if(!checked[i]){
                    checked[i] = true;
                    tempPermus[count] = nums[i];
                    dfs(count+1, nums);
                    checked[i] = false;
                }
            }
        }
    }
}
