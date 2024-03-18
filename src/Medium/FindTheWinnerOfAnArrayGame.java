package Medium;

public class FindTheWinnerOfAnArrayGame {
    public int getWinner(int[] arr, int k) {
        int origin = 0;
        int count = 0;
        for(int i=1; i<arr.length; i++){
            if(arr[origin] > arr[i]){
                count++;
            } else{
                origin = i;
                count = 1;
            }
            if(count == k) return arr[origin];
        }

        return arr[origin];
    }
}
