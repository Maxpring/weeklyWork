//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中
//的 单词数目 。如果不存在这样的转换序列，返回 0。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 
// 👍 739 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//Java：单词接龙
public class P127WordLadder {
    public static void main(String[] args) {
        Solution solution = new P127WordLadder().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
            Set<String> wordSet = new HashSet<>(wordList);
            if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
                return 0;
            }
            wordSet.remove(beginWord);

            // 第 2 步：图的广度优先遍历，必须使用队列和表示是否访问过的 visited 哈希表
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            Set<String> visited = new HashSet<>();
            visited.add(beginWord);

            // 第 3 步：开始广度优先遍历，包含起点，因此初始化的时候步数为 1
            int step = 1;
            while (!queue.isEmpty()) {
                int currentSize = queue.size();
                for (int i = 0; i < currentSize; i++) {
                    // 依次遍历当前队列中的单词
                    String currentWord = queue.poll();
                    // 如果 currentWord 能够修改 1 个字符与 endWord 相同，则返回 step + 1
                    if (changeWordEveryOneLetter(currentWord, endWord, queue, visited, wordSet)) {
                        return step + 1;
                    }
                }
                step++;
            }
            return 0;
        }

        /**
         * 尝试对 currentWord 修改每一个字符，看看是不是能与 endWord 匹配
         *
         * @param currentWord
         * @param endWord
         * @param queue
         * @param visited
         * @param wordSet
         * @return
         */
        private boolean changeWordEveryOneLetter(String currentWord, String endWord,
                                                 Queue<String> queue, Set<String> visited, Set<String> wordSet) {
            char[] charArray = currentWord.toCharArray();
            for (int i = 0; i < endWord.length(); i++) {
                // 先保存，然后恢复
                char originChar = charArray[i];
                for (char k = 'a'; k <= 'z'; k++) {
                    if (k == originChar) {
                        continue;
                    }
                    charArray[i] = k;
                    String nextWord = String.valueOf(charArray);
                    if (wordSet.contains(nextWord)) {
                        if (nextWord.equals(endWord)) {
                            return true;
                        }
                        if (!visited.contains(nextWord)) {
                            queue.add(nextWord);
                            // 注意：添加到队列以后，必须马上标记为已经访问
                            visited.add(nextWord);
                        }
                    }
                }
                // 恢复
                charArray[i] = originChar;
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
