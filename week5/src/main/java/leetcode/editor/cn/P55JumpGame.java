//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心算法 数组 
// 👍 1163 👎 0


package leetcode.editor.cn;

//Java：跳跃游戏
public class P55JumpGame {
    public static void main(String[] args) {
        Solution solution = new P55JumpGame().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法一：贪心
         *
         * @param nums
         * @return
         */
        public boolean canJump1(int[] nums) {
            int length = nums.length;
            if (length <= 1) return true;

            int cover = 0;
            for (int i = 0; i <= cover; i++) {
                cover = Math.max(i + nums[i], cover);
                if (cover >= nums.length - 1) return true;
            }
            return false;
        }

        /**
         * 方法二：动态规划
         *
         * @param nums
         * @return
         */
        public boolean canJump(int[] nums) {
            int length = nums.length;
            if (length == 1) return true;
            if (nums[0] == 0) return false;

            int[] dp = new int[length];
            dp[0] = nums[0];
            for (int i = 1; i < length; i++) {
                dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
                if (dp[i] + i + 1 >= length) return true;
                else if (dp[i] == 0) return false;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
