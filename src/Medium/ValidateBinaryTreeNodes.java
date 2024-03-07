package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ValidateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent = new int[n];
        HashSet<Integer> heads = new HashSet();
        Arrays.fill(parent,-1);
        for(int i=0; i<n; i++){
            int l = leftChild[i];
            int r = rightChild[i];
            if(parent[i] == -1) heads.add(i);
            if(l != -1){
                if(parent[i] == l || parent[l] != -1) return false;
                parent[l] = i;
                heads.remove(l);
            }
            if(r != -1){
                if(parent[i] == r || parent[r] != -1) return false;
                parent[r] = i;
                heads.remove(r);
            }
        }


        if(heads.size() == 1){
            int head = heads.iterator().next();
            ArrayList<Integer> arr = new ArrayList();
            int count = 1;
            arr.add(head);
            while(!arr.isEmpty()){
                ArrayList<Integer> temp = new ArrayList();
                for(int i:arr){
                    if(leftChild[i] != -1){
                        temp.add(leftChild[i]);
                        count++;
                    }
                    if(rightChild[i] != -1){
                        temp.add(rightChild[i]);
                        count++;
                    }
                }
                arr = temp;
            }
            return count == n;
        } else{
            return false;
        }
    }
}
