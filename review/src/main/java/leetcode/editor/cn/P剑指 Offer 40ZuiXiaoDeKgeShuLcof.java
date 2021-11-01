////输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
////
////
////
//// 示例 1：
////
//// 输入：arr = [3,2,1], k = 2
////输出：[1,2] 或者 [2,1]
////
////
//// 示例 2：
////
//// 输入：arr = [0,1,2,1], k = 1
////输出：[0]
////
////
////
//// 限制：
////
////
//// 0 <= k <= arr.length <= 10000
//// 0 <= arr[i] <= 10000
////
//// Related Topics 数组 分治 快速选择 排序 堆（优先队列）
//// 👍 279 👎 0
//
//
//package leetcode.editor.cn;
//
//import java.util.PriorityQueue;
//import java.util.Queue;
//
////Java：最小的k个数
//public class P剑指 Offer 40ZuiXiaoDeKgeShuLcof{
//public static void main(String[]args){
//        Solution solution=new P剑指 Offer 40ZuiXiaoDeKgeShuLcof().new Solution();
//        // TO TEST
//        }
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int[] getLeastNumbers(int[] arr, int k) {
//        if (k <= 0) return new int[0];
//        Queue<Integer> pq = new PriorityQueue<>((e1, e2) -> (e2 - e1));
//        for (int num : arr) {
//            if (pq.size() < k) {
//                pq.offer(num);
//            } else if (num < pq.peek()) {
//                pq.poll();
//                pq.offer(num);
//            }
//        }
//        int[] res = new int[pq.size()];
//
//        int idx = 0;
//        for (Integer num : pq) {
//            res[idx++] = num;
//        }
//        return res;
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//}
