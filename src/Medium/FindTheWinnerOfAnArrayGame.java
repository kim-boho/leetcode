package Medium;

public class FindTheWinnerOfAnArrayGame {
    public int getWinner(int[] arr, int k) {
        int max = arr[0];
        int maxIdx = 0;
        for(int i=1; i<arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
                maxIdx = i;
            }
        }

        int origin = 0;
        int moving = 1;

        while(moving <= maxIdx){
            int count = origin == 0 && moving == 1? 0:1;
            while(count < k && arr[origin] > arr[moving]){
                count++;
                moving++;
            }

            if(count == k) return arr[origin];

            origin = moving;
            moving++;
        }

        return max;
    }
}
