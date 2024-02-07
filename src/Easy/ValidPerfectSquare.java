package Easy;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        return Math.sqrt(num) == (double) ((int) Math.sqrt(num));
    }
}
