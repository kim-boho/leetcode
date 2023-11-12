package Medium;

import java.util.Arrays;

public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int rad = 0;
        for (int h : houses) {
            int start = 0;
            int end = heaters.length - 1;
            while (start < end) {
                int mid = (start + end) / 2;
                if (Math.abs(start - end) == 1) {
                    int minRad = Math.min(Math.abs(heaters[start] - h), Math.abs(heaters[end] - h));
                    if (rad < minRad) rad = minRad;
                    break;
                }
                if (heaters[mid] == h) break;
                else if (heaters[mid] > h) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            if (start == end) {
                if (rad < Math.abs(heaters[start] - h)) rad = Math.abs(heaters[start] - h);
            }
        }
        return rad;
    }
}
