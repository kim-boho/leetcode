package Hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        if(maxHeap.size() == 0) maxHeap.offer(num);
        else{
            if(maxHeap.peek()<num) minHeap.offer(num);
            else maxHeap.offer(num);

            if(maxHeap.size()-minHeap.size() == 2) minHeap.offer(maxHeap.poll());
            else if(minHeap.size()-maxHeap.size() == 2) maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if(minHeap.size()==0) return maxHeap.peek();
        else{
            if(maxHeap.size() == minHeap.size()) return (((double)maxHeap.peek())+((double)minHeap.peek()))/2;
            else if(maxHeap.size()>minHeap.size()) return (double)maxHeap.peek();
            else return (double)minHeap.peek();
        }
    }
}
