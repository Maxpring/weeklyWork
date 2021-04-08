//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 
//
// 进阶： 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？ 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 105 
// 
//
// 
// 
// Related Topics 数组 
// 👍 937 👎 0


package leetcode.editor.cn;

//Java：旋转数组
public class P189RotateArray {
    public static void main(String[] args) {
        Solution solution = new P189RotateArray().new Solution();
        // TO TEST
        int[] arr = {-1, -100, 3, 99};
        solution.rotate(arr, 2);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
            int count = 0;
            int i = 0;
            int now = nums[i];
            int length = nums.length;
            int i1 = length & 0x1;
            if (i1 == 1) {
                while (count <= length) {
                    i += k;
                    if (i > length - 1) {
                        i = i - length;
                    }
                    int temp = nums[i];
                    nums[i] = now;
                    now = temp;
                    count++;
                }
            }else {
                while (count <= length/2) {
                    i += k;
                    if (i > length - 1) {
                        i = i - length;
                    }
                    int temp = nums[i];
                    nums[i] = now;
                    now = temp;
                    count++;
                }
                i = 1;
                now = nums[i];
                while (count <= length/2) {
                    i += k;
                    if (i > length - 1) {
                        i = i - length;
                    }
                    int temp = nums[i];
                    nums[i] = now;
                    now = temp;
                    count++;
                }
            }

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
