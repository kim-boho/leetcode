package Easy;

public class MaximumAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double avg = 0;
        for(int i=0; i<nums.length; i++){
            if(i<k){
                sum += nums[i];
                if(i == k-1) avg = sum/((double)k);
            } else{
                sum -= nums[i-k];
                sum += nums[i];
                if(avg < sum/(double)k) avg = sum/(double)k;
            }
        }
        return avg;
    }
}
