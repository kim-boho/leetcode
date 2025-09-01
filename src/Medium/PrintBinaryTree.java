package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<>();
        List<String> allNodes = dfsReturChildStrings(root);
        ArrayList<Integer> idxs = new ArrayList<>();
        idxs.add(allNodes.size()/2);
        boolean isLast = false;
        boolean[] checkdNode = new boolean[allNodes.size()];
        while(!isLast){
            List<String> tempAns = new ArrayList<>();
            ArrayList<Integer> tempIdxs= new ArrayList<>();
            int prevIdx = 0;
            isLast = idxs.get(0) == 0;
            for(int i=0; i<idxs.size(); i++){
                int nextIdxToPut = idxs.get(i);
                for(int j=prevIdx; j<nextIdxToPut; j++) tempAns.add("");
                if(!checkdNode[nextIdxToPut]){
                    tempAns.add(allNodes.get(nextIdxToPut));
                    checkdNode[nextIdxToPut] = true;
                } else tempAns.add("");
                tempIdxs.add(prevIdx+(nextIdxToPut-prevIdx)/2);
                tempIdxs.add(nextIdxToPut);
                prevIdx = nextIdxToPut+1;
            }
            for(int j=prevIdx; j<allNodes.size(); j++) tempAns.add("");
            ans.add(tempAns);
            if(!isLast){
                tempIdxs.add(prevIdx+(allNodes.size()-prevIdx)/2);
                idxs = tempIdxs;
            }
        }

        return ans;
    }

    private LinkedList<String> dfsReturChildStrings(TreeNode root){
        LinkedList<String> ans = new LinkedList<>();
        if(root == null){
            ans.add("");
            return ans;
        }
        if(root.left == null && root.right == null){
            ans.add(String.valueOf(root.val));
            return ans;
        }
        LinkedList<String> left = dfsReturChildStrings(root.left);
        LinkedList<String> right = dfsReturChildStrings(root.right);
        if(left.size() != right.size()){
            LinkedList<String> shorter = left.size() < right.size()? left:right;
            int targetedSize = Math.max(left.size(),right.size());
            if(shorter.size() == 0) shorter.add("");
            while(shorter.size() < targetedSize){
                for(int i=0; i<shorter.size(); i+=2){
                    shorter.add(i,"");
                    if(i+2 < shorter.size()) shorter.add(i+2,"");
                    else shorter.add("");
                    i+=2;
                }
            }
        }
        ans.addAll(left);
        ans.add(String.valueOf(root.val));
        ans.addAll(right);
        return ans;
    }
}
