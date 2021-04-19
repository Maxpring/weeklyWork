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
// 👍 564 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：组合
public class P77Combinations {
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            ArrayList<List<Integer>> result = new ArrayList<>();
            ArrayList<Integer> level = new ArrayList<>();
            dfs(n, k, 1, level, result);
            return result;
        }

        private void dfs(int n, int k, int start, List<Integer> level, ArrayList<List<Integer>> result) {
            if (k == 0) {
                result.add(level);
                return;
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
