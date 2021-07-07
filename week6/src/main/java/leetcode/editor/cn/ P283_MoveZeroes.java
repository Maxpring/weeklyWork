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
// 👍 1052 👎 0


package leetcode.editor.cn;

//移动零

class P283_MoveZeroes {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P283_MoveZeroes().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            if (nums.length == 1) return;
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int temp = nums[i];
				    nums[i] = nums[j];
				    nums[j] = temp;
				    j++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}