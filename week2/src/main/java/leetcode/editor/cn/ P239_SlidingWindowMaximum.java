//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 947 👎 0


package leetcode.editor.cn;

//滑动窗口最大值

import java.util.LinkedList;
import java.util.PriorityQueue;

class P239_SlidingWindowMaximum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P239_SlidingWindowMaximum().new Solution();
    }

    /**
     * 方法一：
     * 双端队列实现
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        return result;
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法二：
         * PriorityQueue大顶堆实现
         *
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0 || k == 0) return new int[0];
            //默认小根堆，修改Comparator成为大根堆
            PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> {
                return (o2[0] - o1[0]);
            });
            int flag = 0;
            int[] result = new int[nums.length - k + 1];

            for (int i = 0; i < k; i++) {
                heap.offer(new int[]{nums[i], i});
            }
            result[flag++] = heap.peek()[0];
            for (int right = k; right < nums.length; right++) {
                heap.offer(new int[]{nums[right], right});
                //判断当前堆顶元素是否在当前的滑动窗口中
                while(heap.peek()[1] < right - k + 1){

                    heap.poll();
                }
                result[flag++] = heap.peek()[0];
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}