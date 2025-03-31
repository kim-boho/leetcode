package Easy;

import java.util.ArrayDeque;
import java.util.Queue;

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<arr.length; i++){
            if(!q.isEmpty()){
                int num = q.poll();
                if(num == 0){
                    q.add(arr[i]);
                    arr[i] = 0;
                    if(i+1  <  arr.length){
                        q.add(arr[++i]);
                        arr[i] = 0;
                    }
                }else{
                    q.add(arr[i]);
                    arr[i] =  num;
                }
            } else{
                if(arr[i] == 0){
                    if(i+1 < arr.length){
                        q.add(arr[i+1]);
                        arr[++i] = 0;
                    }
                }
            }
        }
        return;
    }
}
