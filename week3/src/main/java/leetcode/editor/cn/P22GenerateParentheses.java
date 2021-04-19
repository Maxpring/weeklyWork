//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1722 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
        int a = 2;
        testFunc(--a);
    }

    private static void testFunc(int a) {
        System.out.println(a);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 深度优先遍历（回溯法）
         * @param n
         * @return
         */
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            dfs("", n, n, res);
            return res;
        }

        private void dfs(String s, int left, int right, List<String> res) {
            if (left == 0 && right == 0) {
                res.add(s);
                return;
            }
            if (left > 0) dfs(s + "(", left - 1, right, res);

            if (right > left) dfs(s + ")", left, right - 1, res);

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
