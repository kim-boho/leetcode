package Easy;

public class DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        int l = Math.max(start,destination);
        int s = Math.min(start,destination);
        int temp = 0;
        for(int i=0; i<distance.length; i++){
            if(i>=s && i<l) temp += distance[i];
            else sum += distance[i];
        }
        return Math.min(temp, sum);
    }
}
