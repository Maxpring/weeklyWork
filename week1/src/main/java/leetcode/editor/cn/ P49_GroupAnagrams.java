//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 710 👎 0


package leetcode.editor.cn;

//字母异位词分组

import java.util.*;

class P49_GroupAnagrams {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P49_GroupAnagrams().new Solution();

    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams1(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                String keyString = Arrays.toString(chars);
                if (!map.containsKey(keyString)) {
                    map.put(keyString, new ArrayList<String>());
                }
                map.get(keyString).add(strs[i]);
            }
            //
            return new ArrayList<>(map.values());
        }

        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                char[] chars = new char[26];
                for (char c : s.toCharArray()) {
                    chars[c - 'a']++;
                }
                String keyString = Arrays.toString(chars);
                if (!map.containsKey(keyString)) {
                    map.put(keyString, new ArrayList<String>());
                }
                map.get(keyString).add(s);
            }
            return new ArrayList<>(map.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}