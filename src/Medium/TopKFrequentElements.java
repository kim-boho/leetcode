package Medium;

import java.util.Arrays;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        if(k==0) return null;
        else if(nums.length == 1) return nums;
        int[] counting = new int[k];
        int[] element = new int[k];
        Arrays.sort(nums);
        int prev = 0;
        int count = 0;
        int currentElement = 0;
        for(int i=0; i<nums.length; i++){
            if(count == 0){
                count++;
                prev = nums[i];
            }
            else if(nums[i] == prev) count++;
            else{
                for(int j=0; j<k; j++){
                    if(counting[j]<count){
                        int temp = counting[j];
                        int tempE = element[j];
                        counting[j] = count;
                        element[j] = prev;
                        while(j+1<k){
                            int temp2 = counting[j+1];
                            int tempE2 = element[j+1];
                            counting[j+1] = temp;
                            element[j+1] = tempE;
                            temp = temp2;
                            tempE = tempE2;
                            j++;
                        }
                    }
                }
                count = 1;
                prev = nums[i];
            }
        }
        if(count != 0){
            for(int j=0; j<k; j++){
                if(counting[j]<count){
                    int temp = counting[j];
                    int tempE = element[j];
                    counting[j] = count;
                    element[j] = prev;
                    while(j+1<k){
                        int temp2 = counting[j+1];
                        int tempE2 = element[j+1];
                        counting[j+1] = temp;
                        element[j+1] = tempE;
                        temp = temp2;
                        tempE = tempE2;
                        j++;
                    }
                }
            }
        }
        return element;
    }
}
