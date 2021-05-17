//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 379 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：有效的字母异位词
public class P242ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new P242ValidAnagram().new Solution();
        // TO TEST
        boolean anagram = solution.isAnagram("anagram", "nagaram");
        System.out.println(anagram);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;
            int[] alphaBet = new int[26];
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();

            for (int i = 0; i < s.length(); i++) {
                int i1 = sChars[i] - 'a';
                alphaBet[i1]++;
                int i2 = tChars[i] - 'a';
                alphaBet[i2]--;
            }

            for (int i = 0; i < alphaBet.length; i++) {
                if (alphaBet[i] != 0) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
