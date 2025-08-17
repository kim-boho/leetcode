package Medium;

public class ImplementRand10UsingRand7 {
    public int rand10() {
        int decideNumber = rand7();
        int ans = rand7();
        while(decideNumber == 4) decideNumber = rand7();
        while(ans > 5) ans = rand7();
        if(decideNumber > 4) ans += 5;
        return ans;
    }

    public int rand7(){
        // return number 1~7 randomly
        return 0;
    }
}
