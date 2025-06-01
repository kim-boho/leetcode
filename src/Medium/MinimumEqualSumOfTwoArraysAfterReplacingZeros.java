package Medium;

public class MinimumEqualSumOfTwoArraysAfterReplacingZeros {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        int zeros1 = 0;
        long sum2 = 0;
        int zeros2 = 0;
        for(int n:nums1){
            sum1 += n;
            if(n == 0) zeros1++;
        }
        for(int n:nums2){
            sum2 += n;
            if(n == 0) zeros2++;
        }
        if(sum1 == sum2){
            if(zeros1 == 0 && zeros2 == 0) return sum1;
            else if(zeros1 == 0 || zeros2 == 0) return -1;
            else{
                return Math.max(sum1+zeros1,sum2+zeros2);
            }
        } else if(sum1 > sum2){
            if(zeros2 == 0) return -1;
            else {
                if(zeros1 == 0 && sum1+zeros1 < sum2+zeros2) return -1;
                else return Math.max(sum1+zeros1,sum2+zeros2);
            }
        } else{
            if(zeros1 == 0) return -1;
            else {
                if(zeros2 == 0 && sum1+zeros1 > sum2+zeros2) return -1;
                else return Math.max(sum1+zeros1,sum2+zeros2);
            }
        }
    }
}
