//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 1099 👎 0


package leetcode.editor.cn;

//乘积最大子数组

class P152_MaximumProductSubarray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P152_MaximumProductSubarray().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int max = Integer.MIN_VALUE;
            int imax = 1;
            int imin = 1;
            for (int num : nums) {
                if (num < 0){
                    int temp = imax;
                    imax = imin;
                    imin = temp;
                }
                imax = Math.max(imax * num, num);
                imin = Math.min(imin * num, num);
                max = Math.max(imax,max);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}