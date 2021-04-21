//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 104] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 设计 
// 👍 546 👎 0


package leetcode.editor.cn;

//二叉树的序列化与反序列化

import leetcode.editor.structure.TreeNode;

import java.util.*;

class P297_SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        //测试代码
    }

    public String serialize(TreeNode root) {
        LinkedList<String> resultList = new LinkedList<>();
        Queue<TreeNode> deque = new ArrayDeque<>();
        if (root != null) deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<String> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                level.add(node == null ? "null" : String.valueOf(node.val));
                if (node.left != null) {
                    deque.offer(node.left);
                } else {
                    deque.offer(null);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                } else {
                    deque.offer(null);
                }
            }
            resultList.addAll(level);
        }
        while (resultList.getLast().equals("null")) {
            resultList.removeLast();
        }
        return resultList.toString();
    }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "null";
            return root.val + "," + serialize(root.left) + "," + serialize(root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
            return dfs(queue);
        }

        private TreeNode dfs(Queue<String> queue) {
            String val = queue.poll();
            if ("null".equals(val)) return null;
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = dfs(queue);
            root.right = dfs(queue);
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}