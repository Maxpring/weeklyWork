//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 666 👎 0


package leetcode.editor.cn;

//Java：x 的平方根
public class P69Sqrtx {
    public static void main(String[] args) {
        Solution solution = new P69Sqrtx().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            // 特殊值判断
            if (x == 0) {
                return 0;
            }
            if (x == 1) {
                return 1;
            }

            int left = 1;
            int right = x / 2;
            // 在区间 [left..right] 查找目标元素
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                // 注意：这里为了避免乘法溢出，改用除法
                if (mid > x / mid) {
                    // 下一轮搜索区间是 [left..mid - 1]
                    right = mid - 1;
                } else {
                    // 下一轮搜索区间是 [mid..right]
                    left = mid;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
