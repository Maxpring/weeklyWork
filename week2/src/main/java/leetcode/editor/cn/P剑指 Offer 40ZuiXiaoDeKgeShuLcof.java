//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 223 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//Java：最小的k个数
class Offer40ZuiXiaoDeKgeShuLcof {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 快速排序
         * O(logn)
         * @param arr
         * @param k
         * @return
         */
        public int[] getLeastNumbers1(int[] arr, int k) {
            if (k == 0 || arr.length == 0) {
                return new int[0];
            }
            // 最后一个参数表示我们要找的是下标为k-1的数
            return quickSearch(arr, 0, arr.length - 1, k - 1);
        }

        private int[] quickSearch(int[] nums, int lo, int hi, int k) {
            // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
            int j = partition(nums, lo, hi);
            if (j == k) {
                return Arrays.copyOf(nums, j + 1);
            }
            // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
            return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
        }

        // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
        private int partition(int[] nums, int lo, int hi) {
            int v = nums[lo];
            int i = lo, j = hi + 1;
            while (true) {
                while (++i <= hi && nums[i] < v) ;
                while (--j >= lo && nums[j] > v) ;
                if (i >= j) {
                    break;
                }
                int t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }
            nums[lo] = nums[j];
            nums[j] = v;
            return j;
        }

        /**
         * 方法二：
         * PriorityQueue构建大根堆，堆内先放进k个，之后与根比较大小，比根小则替换。
         * 时间复杂度：O(nlogk)
         *
         * @param arr
         * @param k
         * @return
         */

        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0 || arr.length == 0) {
                return new int[0];
            }

            Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> (v2 - v1));
            for (int num : arr) {
                if (pq.size() < k) {
                    pq.offer(num);
                } else if (num < pq.peek()) {
                    pq.poll();
                    pq.offer(num);
                }
            }
            int[] res = new int[pq.size()];
            int idx = 0;
            for (Integer num : pq) {
                res[idx++] = num;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
