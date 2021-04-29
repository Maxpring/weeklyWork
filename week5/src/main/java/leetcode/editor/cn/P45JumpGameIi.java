//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
//输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心算法 数组 
// 👍 942 👎 0


package leetcode.editor.cn;

//Java：跳跃游戏 II
public class P45JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new P45JumpGameIi().new Solution();
        // TO TEST
        int[] nums = {2,3,1,1,4};
        int jump = solution.jump(nums);
        System.out.println(jump);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法一：贪心
         *
         * @param nums
         * @return
         */
        public int jump1(int[] nums) {
            int end = 0;
            int maxPosition = 0;
            int steps = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                //找能跳的最远的
                maxPosition = Math.max(maxPosition, nums[i] + i);
                if (i == end) { //遇到边界，就更新边界，并且步数加一
                    end = maxPosition;
                    steps++;
                }
            }
            return steps;
        }

        public int jump(int[] nums) {
            int n = nums.length;
            int[] f = new int[n];
            for (int i = 1, j = 0; i < n; i++) {
                while (j + nums[j] < i) j++;
                System.out.println(f[j]);
                f[i] = f[j] + 1;
            }
            return f[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
