package Medium;

public class DetermineIfACellIsReachableAtAGivenTime {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(sx == fx && sy == fy && t == 1) return false;
        int min = 0;
        int diagStep = Math.min(Math.abs(sx-fx), Math.abs(sy-fy));
        int leftStep = Math.max(Math.abs(sx-fx), Math.abs(sy-fy))-diagStep;
        min += diagStep+leftStep;
        return t>=min;
    }
}
