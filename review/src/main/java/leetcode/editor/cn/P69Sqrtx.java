//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。 
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 231 - 1 
// 
// Related Topics 数学 二分查找 
// 👍 811 👎 0


package leetcode.editor.cn;

//Java：Sqrt(x)
public class P69Sqrtx {
    public static void main(String[] args) {
        Solution solution = new P69Sqrtx().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    //牛顿迭代法
    class Solution {
        int s;

        public int mySqrt(int x) {
            s = x;
            if (x == 0 || x == 1) return x;
            return (int) sqrt(s);
        }

        private double sqrt(double x) {
            double res = (x + s / x) / 2;
            if (res == x)
                return x;
            else
                return sqrt(res);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
