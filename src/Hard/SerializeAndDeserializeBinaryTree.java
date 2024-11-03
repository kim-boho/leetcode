package Hard;

import Medium.TreeNode;

import java.util.ArrayList;

public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return null;
        StringBuilder sb = new StringBuilder();
        ArrayList<TreeNode> li = new ArrayList<>();
        li.add(root);
        while(!li.isEmpty()){
            ArrayList<TreeNode> temp = new ArrayList<>();
            boolean allNull = true;
            for(int i=0; i<li.size(); i++){
                TreeNode t = li.get(i);
                if(t != null){
                    sb.append(t.val);
                    temp.add(t.left);
                    temp.add(t.right);
                    if(t.left != null) allNull = false;
                    if(t.right != null) allNull = false;
                } else sb.append('n');
                sb.append(' ');
            }
            if(allNull){
                int idx = sb.length()-1;
                while(sb.charAt(idx) == 'n' || sb.charAt(idx) == ' ') idx--;
                sb.delete(idx+1,sb.length());
                break;
            }
            li = temp;
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()) return null;
        System.out.println(data);
        String[] arr = data.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        ArrayList<TreeNode> li = new ArrayList<>();
        li.add(root);
        int start = 1;
        while(!li.isEmpty()){
            ArrayList<TreeNode> temp = new ArrayList<>();
            for(int i=0; i<li.size(); i++){
                TreeNode t = li.get(i);
                if(start < arr.length && !arr[start].equals("n")){
                    TreeNode left = new TreeNode(Integer.valueOf(arr[start]));
                    t.left = left;
                    temp.add(left);
                }
                start++;
                if(start < arr.length && !arr[start].equals("n")){
                    TreeNode right = new TreeNode(Integer.valueOf(arr[start]));
                    t.right = right;
                    temp.add(right);
                }
                start++;
            }
            if(start >= arr.length) break;
            li = temp;
        }
        return root;
    }

}
