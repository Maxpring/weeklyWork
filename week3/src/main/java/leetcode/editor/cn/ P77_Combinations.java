//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 563 👎 0


package leetcode.editor.cn;

//组合

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class P77_Combinations {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P77_Combinations().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {


            List<List<Integer>> res = new ArrayList<>();
            if (k <= 0 || n < k) {
                return res;
            }
            Deque<Integer> path = new ArrayDeque<>();
            dfs(n, k, 1, path, res);
            return res;
        }

        private void dfs(int n, int k, int index, Deque<Integer> path, List<List<Integer>> res) {
            if (path.size() == k) {
                res.add(new ArrayList<>(path));
                return;
            }

            // 只有这里 i <= n - (k - path.size()) + 1 与参考代码 1 不同
            for (int i = index; i <= n - (k - path.size()) + 1; i++) {
                path.addLast(i);
                dfs(n, k, i + 1, path, res);
                path.removeLast();
            }
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}