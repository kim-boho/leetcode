package Easy;

public class GuessNumberHigherOrLower {
    public class Solution extends GuessGame {
        public Solution(int target) {
            super(target);
        }

        public int guessNumber(int n) {
            int start = 1;
            int end = n;
            while(start<=end){
                int mid = start+(end-start)/2;
                int res = guess(mid);
                if(res == -1){
                    end = mid-1;
                } else if(res == 1){
                    start = mid+1;
                } else{
                    return mid;
                }
            }
            return 0;
        }
    }

    public class GuessGame{
        public int target;
        public GuessGame(int target){
            this.target = target;
        }
        public int guess(int guessNum){
            if(guessNum > target){
                return -1;
            } else if(guessNum < target){
                return 1;
            } else return 0;
        }
    }
}
