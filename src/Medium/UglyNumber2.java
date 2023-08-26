package Medium;

public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        if(n == 1) return n;
        int[] nums = new int[n];
        nums[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        int nextIdx = 1;

        int next1 = nums[p2]*2;
        int next2 = nums[p3]*3;
        int next3 = nums[p5]*5;

        while(nextIdx < n){
            int temp = 0;
            if(next1 <= next2 && next1 <= next3){
                nums[nextIdx] = next1;
                temp = next1;
            } else if(next2 <= next1 && next2 <= next3){
                nums[nextIdx] = next2;
                temp = next2;
            } else{
                nums[nextIdx] = next3;
                temp = next3;
            }

            if(next1 == temp){
                p2++;
                next1 = nums[p2]*2;
            }
            if(next2 == temp){
                p3++;
                next2 = nums[p3]*3;
            }
            if(next3 == temp){
                p5++;
                next3 = nums[p5]*5;
            }
            nextIdx++;
        }
        return nums[n-1];
    }
}
