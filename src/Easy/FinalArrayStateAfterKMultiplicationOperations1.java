package Easy;

import java.util.PriorityQueue;

public class FinalArrayStateAfterKMultiplicationOperations1 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        for(int i=0; i<nums.length; i++){
            pq.add(new int[] {nums[i],i});
        }

        for(int i=0; i<k; i++){
            int[] arr = pq.poll();
            nums[arr[1]] = nums[arr[1]]*multiplier;
            arr[0] = nums[arr[1]];
            pq.add(arr);
        }
        return nums;
    }
}
