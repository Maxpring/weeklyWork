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
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> resultList = new ArrayList<>();
            if (n == 0) return resultList;

            dfs(n, n, "", resultList);
            return resultList;
        }

        private void dfs(int left, int right, String s, List<String> resultList) {
            //terminator
            if (left == 0 && right == 0) {
                resultList.add(s);
                return;
            }
            if (left > right) return;

            if (left > 0) {
                dfs(left - 1, right, s + "(", resultList);
            }
            if (right > 0) {
                dfs(left, right - 1, s + ")", resultList);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
