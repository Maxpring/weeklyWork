//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1141 👎 0


package leetcode.editor.cn;

//子集

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class P78_Subsets {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P78_Subsets().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法一
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> subsets2(int[] nums) {
            ArrayList<List<Integer>> result = new ArrayList<>();
            if (nums == null) return result;
            dfs(result, nums, new ArrayList<>(), 0);
            return result;
        }

        private void dfs(ArrayList<List<Integer>> result, int[] nums, List<Integer> list, int index) {
            //terminator
            if (index == nums.length) {
                result.add(new ArrayList<Integer>(list));
                return;
            }
            dfs(result, nums, list, index + 1);//not pick the number at this index
            list.add(nums[index]);
            dfs(result, nums, list, index + 1);//pick the number at this index
            list.remove(list.size() - 1);
            //reverse the current state
        }

        /**
         * 方法二
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> subsets(int[] nums) {
            int length = nums.length;
            List<List<Integer>> list = new ArrayList<>();
            Deque<Integer> path = new ArrayDeque<>();
            dfs2(list, nums, length, path, 0);
            return list;
        }

        private void dfs2(List<List<Integer>> list, int[] nums, int length, Deque<Integer> path, int begin) {
            list.add(new ArrayList<>(path));
            if (length == begin) return;

            for (int i = begin; i < length; i++) {
                path.add(nums[i]);
                dfs2(list, nums, length, path, i + 1);
                path.removeLast();
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}