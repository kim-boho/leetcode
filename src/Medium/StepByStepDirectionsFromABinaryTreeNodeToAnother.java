package Medium;

import java.util.ArrayList;

public class StepByStepDirectionsFromABinaryTreeNodeToAnother {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startPath = new StringBuilder();
        StringBuilder destPath = new StringBuilder();
        ArrayList<Character> li = new ArrayList<>();

        recursion(li, root, startPath, startValue);
        li = new ArrayList<>();
        recursion(li, root, destPath, destValue);

        if(root.val == startValue){
            return destPath.toString();
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<startPath.length(); i++) sb.append('U');

        if(root.val == destValue){
            return sb.toString();
        } else{
            int i = 0;
            int len1 = startPath.length();
            int len2 = destPath.length();
            while(i < len1 && i < len2 && startPath.charAt(i) == destPath.charAt(i)) i++;
            if(i == len1){
                return destPath.toString().substring(i,len2);
            }
            if(i == len2){
                return sb.toString().substring(i,len1);
            }
            return sb.toString().substring(i,len1)+destPath.toString().substring(i,len2);

        }
    }

    private void recursion(ArrayList<Character> li, TreeNode t, StringBuilder sb, int value){
        if(sb.length() != 0) return;
        if(t == null) return;
        if(t.val == value){
            for(char c:li){
                sb.append(c);
            }
            return;
        }

        li.add('L');
        recursion(li,t.left,sb,value);
        li.remove(li.size()-1);

        li.add('R');
        recursion(li,t.right,sb,value);
        li.remove(li.size()-1);
    }
}
