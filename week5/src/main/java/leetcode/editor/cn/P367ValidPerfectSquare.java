//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics 数学 二分查找 
// 👍 207 👎 0


package leetcode.editor.cn;

//Java：有效的完全平方数
public class P367ValidPerfectSquare {
    public static void main(String[] args) {
        String openId = "ea7487947fb14dbea4ef5e09a0c7c3a7";
        int SHARDING_THRESHOLD = 0xffff;
        int seed = 131;
        long hash = 0;
        for (int i = 0; i < openId.length(); i++) {
            hash = (hash * seed) + openId.charAt(i);
        }
        int shardValue = (int) (hash & 0x7fffffffffffffffL & SHARDING_THRESHOLD);
        System.out.println(shardValue);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            if (num == 1) return true;
            long left = 2;
            long right = num / 2;
            long x, guessSquared;
            while (left <= right) {
                x = left + (right - left) / 2;
                guessSquared = x * x;
                if (guessSquared == num) return true;
                if (guessSquared > num) {
                    right = x - 1;
                } else {
                    left = x + 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
