package Medium;

public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int total = 0;
        int left = 0;
        int right = 0;
        int tempSat = 0;
        int maxSat = 0;
        int n = grumpy.length;
        while(right < n){
            if(right < minutes){
                if(grumpy[right] == 1){
                    tempSat += customers[right];
                } else total += customers[right];
            } else{
                if(maxSat < tempSat) maxSat = tempSat;
                if(grumpy[right] == 1) tempSat += customers[right];
                else total += customers[right];
                if(grumpy[left] == 1) tempSat -= customers[left];
                left++;
            }
            right++;
        }
        if(maxSat < tempSat) maxSat = tempSat;
        return total+maxSat;
    }
}
