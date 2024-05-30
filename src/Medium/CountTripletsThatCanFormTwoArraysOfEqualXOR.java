package Medium;

public class CountTripletsThatCanFormTwoArraysOfEqualXOR {
    public int countTriplets(int[] arr) {
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            int base = arr[i];
            for(int j=i+1; j<arr.length; j++){
                base ^= arr[j];
                if(base == 0){
                    ans += (j-i);
                }
            }
        }
        return ans;
    }
}
