package DFSandBFS;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/21/16:50
 * @Description: 三尺秋水尘不染
 */
/*示例 1：

        输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
        输出：5
        解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
        示例 2：

        输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
        输出：0
        解释：endWord "cog" 不在字典中，所以无法进行转换。
         

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/word-ladder
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class ladderLength {

    /*
         * @Method: ladderLength
         * @Description: 三尺秋水尘不染
         *  * @param beginWord
         * @param endWord
         * @param wordList
         * @paramType:
         [java.lang.String, java.lang.String, java.util.List<java.lang.String>]
         * @return：int
         * @Author: HaRiJi
         * @Date: 2021/9/21
         */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        HashSet<String> wordSet = new HashSet<>(wordList);
        //终止条件更具提议
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        //.结果集合中没有 开始的凡此
        wordSet.remove(beginWord);

        // 第 2 步：图的广度优先遍历，必须使用队列和表示是否访问过的 visited 哈希表
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // 第 3 步：开始广度优先遍历，包含起点，因此初始化的时候步数为 1
        int step = 1;
        //queue是动态的需要动态判断
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

    /*
     * @Method: changeWordEveryOneLetter
     * @Description: 三尺秋水尘不染
     *  * @param currentWord
     * @param endWord
     * @param queue
     * @param visited
     * @param wordSet
     * @paramType:
     [java.lang.String, java.lang.String, java.util.Queue<java.lang.String>, java.util.Set<java.lang.String>, java.util.Set<java.lang.String>]
     * @return：boolean
     * @Author: HaRiJi
     * @Date: 2021/9/21
     */
    private boolean changeWordEveryOneLetter(String currentWord, String endWord,
                                             Queue<String> queue, Set<String> visited, Set<String> wordSet) {

        char[] charArray = currentWord.toCharArray();

        for (int i = 0; i < endWord.length(); i++) {
            // 先保存，然后恢复
            //就三位012
            char originChar = charArray[i];
            //匹配
            for (char k = 'a'; k <= 'z'; k++) {
                if (k == originChar) {
                    continue;
                }

                charArray[i] = k;
                //取出转换
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



