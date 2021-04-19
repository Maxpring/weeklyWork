//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 996 👎 0


package leetcode.editor.cn;

import structure.TreeNode;

//Java：从前序与中序遍历序列构造二叉树
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int length = preorder.length;
            if (length == 0) {
                return null;
            }
            int rootVal = preorder[0];
            int i = 0;
            while (rootVal != inorder[i]) {
                i++;
            }
            int[] leftInOrder = new int[i];
            int[] leftPreOrder = new int[i];
            for (int j = 0; j < i; j++) {
                leftInOrder[j] = inorder[j];
                leftPreOrder[j] = preorder[j + 1];
            }

            int[] rightInOrder = new int[length - i - 1];
            int[] rightPreOrder = new int[length - i - 1];
            for (int j = 0; j < length - i - 1; j++) {
                rightInOrder[j] = inorder[i + 1 + j];
                rightPreOrder[j] = preorder[i + 1 + j];
            }


            TreeNode root = new TreeNode(rootVal);
            root.left = buildTree(leftPreOrder, leftInOrder);
            root.right = buildTree(rightPreOrder, rightInOrder);
            return root;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
