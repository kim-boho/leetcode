package Medium;

public class ConvertBSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return root;
        int temp = addRights(0,root);
        return root;
    }

    private int addRights(int num, TreeNode node){
        int sum = num;
        if(node.right != null){
            sum += (addRights(num,node.right)-num);
        }
        sum += node.val;
        int temp = 0;
        if(node.left != null){
            temp = addRights(sum,node.left);
        }
        node.val = sum;
        return temp != 0? temp:sum;
    }
}
