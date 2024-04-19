package Hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MeetingRooms3 {
    public int mostBooked(int n, int[][] meetings) {
        int[] rooms = new int[n];
        boolean[] isOccupied = new boolean[n];
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Long> endTimes = new PriorityQueue<>();
        HashMap<Long, PriorityQueue<Integer>> pairs = new HashMap<>();

        for (int[] meeting : meetings) {
            boolean assigned = false;
            long start = meeting[0];
            long end = meeting[1];
            while (!endTimes.isEmpty() && endTimes.peek() <= start) {
                PriorityQueue<Integer> empties = pairs.remove(endTimes.poll());
                while (!empties.isEmpty()) isOccupied[empties.poll()] = false;
            }
            for (int j = 0; j < n; j++) {
                if (!isOccupied[j]) {
                    rooms[j]++;
                    isOccupied[j] = true;
                    assigned = true;
                    if (pairs.containsKey(end)) {
                        pairs.get(end).add(j);
                    } else {
                        PriorityQueue<Integer> temp = new PriorityQueue<>();
                        temp.add(j);
                        pairs.put((long) end, temp);
                        endTimes.add((long) end);
                    }
                    break;
                }
            }
            if (!assigned) {
                long nextAvailableTime = endTimes.peek();
                int nextRoom = pairs.get(nextAvailableTime).poll();
                if (pairs.get(nextAvailableTime).size() == 0) {
                    pairs.remove(nextAvailableTime);
                    endTimes.poll();
                }
                rooms[nextRoom]++;
                long modifiedEndTime = nextAvailableTime - start + end;
                if (pairs.containsKey(modifiedEndTime)) {
                    pairs.get(modifiedEndTime).add(nextRoom);
                } else {
                    PriorityQueue<Integer> temp = new PriorityQueue<>();
                    temp.add(nextRoom);
                    pairs.put(modifiedEndTime, temp);
                    endTimes.add(modifiedEndTime);
                }
            }
        }

        int max = -1;
        int idx = -1;
        for(int i=0; i<n; i++){
            if(rooms[i] > max){
                max = rooms[i];
                idx = i;
            }
        }
        return idx;
    }
}
