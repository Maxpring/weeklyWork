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

//x 的平方根

import javax.management.remote.rmi._RMIConnection_Stub;

class P69_Sqrtx {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P69_Sqrtx().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            if (x == 0) return 0;
            if (x == 1) return 1;

            int left = 1;
            int right = x / 2;

            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (mid > x / mid) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}