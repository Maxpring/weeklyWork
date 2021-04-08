package structure;

/**
 * @author: zhangyk
 * @Date: 2021/4/8 10:23
 * @Description:
 * @Version: 1.0
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

