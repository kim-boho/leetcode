package Medium;

public class FindTheMaximumLengthOfValidSubsequence1 {
    public int maximumLength(int[] nums) {
        boolean isEvenPrev = nums[0] % 2 == 0;
        int alter = 1;
        int even = isEvenPrev? 1:0;
        int odd = isEvenPrev? 0:1;
        for(int i=1; i<nums.length; i++){
            boolean isEven = nums[i] % 2 == 0;
            if(isEven) even++;
            else odd++;
            if(isEvenPrev){
                if(!isEven){
                    isEvenPrev = false;
                    alter++;
                }
            } else{
                if(isEven){
                    isEvenPrev = true;
                    alter++;
                }
            }
        }
        return Math.max(alter,Math.max(even,odd));
    }
}
