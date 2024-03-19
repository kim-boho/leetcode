package Medium;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        int max = 0;
        for(char c:tasks){
            arr[c-'A']++;
            if(max < arr[c-'A']) max = arr[c-'A'];
        }

        if(max * (n+1) <= tasks.length) return tasks.length;
        else{
            int count = 0;
            for(int i:arr){
                if(i == max) count++;
            }
            return Math.max((max-1)*(n+1)+count,tasks.length);
        }
    }
}
