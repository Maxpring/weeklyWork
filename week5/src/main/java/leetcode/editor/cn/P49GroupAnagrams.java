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
// 👍 733 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Java：字母异位词分组
public class P49GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new P49GroupAnagrams().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> result = new ArrayList<>();
            if (strs.length < 1) return result;
            HashMap<String, List<String>> map = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                String s = String.valueOf(chars);
                if (!map.containsKey(s)) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(strs[i]);
                    map.put(s, list);
                } else {
                    map.get(s).add(strs[i]);
                }
            }
            /*for (String s : map.keySet()) {
                result.add(map.get(s));
            }*/
            result.addAll(map.values());
            System.out.println(result);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
