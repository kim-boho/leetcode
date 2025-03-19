package Medium;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class DesignSnakeGame {
    Queue<Integer> tailsQ;
    HashSet<Integer> tailsHs;
    int nextFood;
    int m;
    int n;
    int r;
    int c;
    int[][] food;
    int score;
    public DesignSnakeGame(int width, int height, int[][] food) {
        tailsQ = new ArrayDeque<>();
        tailsHs = new HashSet<>();
        nextFood = 0;
        m = height;
        n = width;
        r = 0;
        c = 0;
        this.food = food;
        score = 0;
    }

    public int move(String direction) {
        if(direction.equals("U")) r--;
        else if(direction.equals("D")) r++;
        else if(direction.equals("L")) c--;
        else c++;
        if(r >= m || r < 0 || c >= n || c < 0) return -1;
        int num = r*n+c;
        if(tailsHs.contains(num)) return -1;
        if(nextFood < food.length && food[nextFood][0] == r && food[nextFood][1] == c){
            score++;
            tailsQ.add(num);
            tailsHs.add(num);
            nextFood++;
        } else{
            if(!tailsQ.isEmpty()){
                tailsHs.remove(tailsQ.poll());
                tailsHs.add(num);
                tailsQ.add(num);
            }
        }
        return score;
    }
}
