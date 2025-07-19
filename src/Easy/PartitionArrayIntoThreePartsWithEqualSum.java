package Easy;

public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for(int n:arr) sum += n;
        if(sum % 3 != 0) return false;
        int k = sum/3;
        int partSum = 0;
        int partition = 0;
        for(int i=0; i<arr.length; i++){
            partSum += arr[i];
            if(partSum == k){
                partition++;
                partSum = 0;
            }
            if(partition == 3) return true;
        }
        return false;
    }
}
