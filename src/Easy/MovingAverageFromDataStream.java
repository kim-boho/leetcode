package Easy;

public class MovingAverageFromDataStream {
    int count;
    int[] arr;
    int i;
    double sum;
    public MovingAverageFromDataStream(int size) {
        count = size;
        arr = new int[size];
        i = 0;
        sum = 0;
    }

    public double next(int val) {
        double len;
        if(count == 0){
            sum -= arr[i];
            len = arr.length;
        } else{
            count--;
            len = i+1;
        }
        arr[i] = val;
        i++;
        i %= arr.length;
        sum += val;
        return sum/len;
    }
}
