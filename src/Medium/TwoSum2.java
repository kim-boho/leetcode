package Medium;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for(int i=0; i<n; i++){
            int num = numbers[i];
            int start = i+1;
            int end = n-1;
            while(start<=end){
                int mid = (start+end)/2;
                if(num+numbers[mid] == target){
                    int[] ans = {i+1, mid+1};
                    return ans;
                } else if(num+numbers[mid] < target){
                    start = mid+1;
                } else{
                    end = mid-1;
                }
            }
        }
        return null;
    }
}
