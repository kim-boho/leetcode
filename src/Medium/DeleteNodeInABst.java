package Medium;

public class DeleteNodeInABst {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode pointer = root;
        TreeNode prev = null;
        boolean isLeft = true;
        while(pointer != null){
            if(pointer.val < key){
                prev = pointer;
                pointer = pointer.right;
                isLeft = false;
            } else if(pointer.val > key){
                prev = pointer;
                pointer = pointer.left;
                isLeft = true;
            } else{
                TreeNode temp = pointer;
                if(temp.right != null){
                    prev = temp;
                    temp = temp.right;
                    isLeft = false;
                    while(temp.left != null){
                        prev = temp;
                        temp = temp.left;
                        isLeft = true;
                    }
                    pointer.val = temp.val;
                    if(temp.right != null){
                        if(isLeft) prev.left = temp.right;
                        else prev.right = temp.right;
                    } else{
                        if(isLeft) prev.left = null;
                        else prev.right = null;
                    }
                } else if(temp.left != null){
                    prev = temp;
                    temp = temp.left;
                    isLeft = true;
                    while(temp.right != null){
                        prev = temp;
                        temp = temp.right;
                        isLeft = false;
                    }
                    pointer.val = temp.val;
                    if(temp.left != null){
                        if(isLeft) prev.left = temp.left;
                        else prev.right = temp.left;
                    } else{
                        if(isLeft) prev.left = null;
                        else prev.right = null;
                    }
                } else{
                    if(prev==null) return null;
                    if(isLeft) prev.left = temp.right;
                    else prev.right = temp.right;
                }
                break;
            }
        }

        return root;
    }
}
