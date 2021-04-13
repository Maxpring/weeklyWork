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
// 👍 1717 👎 0


package leetcode.editor.cn;

//括号生成

import java.util.ArrayList;
import java.util.List;

class P22_GenerateParentheses {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P22_GenerateParentheses().new Solution();
        List<String> list = solution.generateParenthesis(3);
        System.out.println(list);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        private List<String> result;

        public List<String> generateParenthesis(int n) {
            result = new ArrayList<>();
            String s = "";
            generator(0, 0, n, s);
            return result;


        }

        private void generator(int left, int right, int n, String s) {
            //terminator
            if (left == n && right == n) {
                result.add(s);
                return;
            }
            //process current logic

            String s1 = s + "(";
            String s2 = s + ")";

            //drill down

            if (left < n)
                generator(left + 1, right, n, s1);
            if (left > right)
                generator(left, right + 1, n, s2);

            // reverse states
        }

       

    }
//leetcode submit region end(Prohibit modification and deletion)

}