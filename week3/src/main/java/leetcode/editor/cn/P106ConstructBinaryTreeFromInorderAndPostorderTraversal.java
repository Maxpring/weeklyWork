//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 487 👎 0


package leetcode.editor.cn;

import structure.TreeNode;

//Java：从中序与后序遍历序列构造二叉树
public class P106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int length = postorder.length;
            if (length == 0) return null;
            int rootVal = postorder[length - 1];
            TreeNode root = new TreeNode(rootVal);
            int i = 0;
            while (rootVal != inorder[i]) {
                i++;
            }

            int[] leftInOrder = new int[i];
            int[] leftPostOrder = new int[i];

            for (int j = 0; j < i; j++) {
                leftInOrder[j] = inorder[j];
                leftPostOrder[j] = postorder[j];
            }

            int[] rightInOrder = new int[length - i - 1];
            int[] rightPostOrder = new int[length - i - 1];

            for (int j = 0; j < length - i - 1; j++) {
                rightInOrder[j] = inorder[i + 1 + j];
                rightPostOrder[j] = postorder[i + j];
            }

            root.left = buildTree(leftInOrder, leftPostOrder);
            root.right = buildTree(rightInOrder, rightPostOrder);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
