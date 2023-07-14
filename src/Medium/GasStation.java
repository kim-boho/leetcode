package Medium;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        for(int i=0; i<gas.length; i++){
            gasSum+=gas[i];
            costSum+=cost[i];
        }
        if(gasSum<costSum) return -1;
        int sum = 0;
        int idx = 0;
        for(int i=0; i<gas.length; i++){
            sum += gas[i]-cost[i];
            if(sum<0){
                sum = 0;
                idx = i+1;
            }
        }
        return idx==gas.length? -1:idx;
    }
}
