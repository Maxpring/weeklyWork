//给定一个字符串数组，将字母异位词组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 104 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 排序 
// 👍 807 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

//Java：字母异位词分组
public class P49GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new P49GroupAnagrams().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> map = new HashMap<>(128);
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String temp = String.valueOf(chars);
                if (map.isEmpty() || !map.containsKey(temp)) {
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    map.put(temp, list);
                } else {
                    List<String> list = map.get(temp);
                    list.add(str);
                    map.put(temp, list);
                }
            }

            return new ArrayList<>(map.values());
        }

        public List<List<String>> groupAnagrams1(String[] strs) {

            return new ArrayList<>(Arrays.stream(strs)
                    .collect(Collectors.groupingBy(str -> {
                        // 返回 str 排序后的结果。
                        // 按排序后的结果来grouping by，算子类似于 sql 里的 group by。
                        char[] array = str.toCharArray();
                        Arrays.sort(array);
                        return new String(array);
                    })).values());
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
