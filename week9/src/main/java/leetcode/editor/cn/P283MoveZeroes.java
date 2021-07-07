//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1099 👎 0


package leetcode.editor.cn;

//Java：移动零
public class P283MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new P283MoveZeroes().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
//                    swap(nums[i], nums[j]);
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j ++;
                }

            }
        }

        private void swap(int a, int b) {
            if (a == b) return;
            int temp = b;
            b = a;
            a = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
