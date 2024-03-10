package Medium;

import java.util.PriorityQueue;

public class SeatReservationManager {

}
class SeatManager {
    PriorityQueue<Integer> seats;
    public SeatManager(int n) {
        seats = new PriorityQueue();
        for(int i=1; i<=n; i++) seats.add(i);
    }

    public int reserve() {
        return seats.poll();
    }

    public void unreserve(int seatNumber) {
        seats.add(seatNumber);
    }
}
