package Medium;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        boolean[] checked = new boolean[nums.length];
        for(int i:nums){
            if(checked[i]) return i;
            else checked[i] = true;
        }
        return -1;
    }
}
