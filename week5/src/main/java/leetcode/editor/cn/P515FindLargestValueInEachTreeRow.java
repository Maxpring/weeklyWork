//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 128 👎 0


package leetcode.editor.cn;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：在每个树行中找最大值
public class P515FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        Solution solution = new P515FindLargestValueInEachTreeRow().new Solution();
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
        public List<Integer> largestValues(TreeNode root) {
            ArrayList<Integer> result = new ArrayList<>();
            if (root == null) return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int levelMax = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    levelMax = Math.max(node.val, levelMax);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                result.add(levelMax);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
