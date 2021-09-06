package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/9/6 15:57
 * @description 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。 你可以假设字典中没有重复的单词。 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"] 输出: true 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet
 * code"。 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"] 输出: true 解释: 返回 true 因为 "applepenapple"
 * 可以被拆分成 "apple pen apple"。      注意你可以重复使用字典中的单词。 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"] 输出: false
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/word-break 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordBreak {

  public static void main(String[] args) {
    String str = "aaaaaaa";
    List<String> list = new ArrayList<>();
    list.add("aaaa");
    list.add("aaa");
    WordBreak wordBreak = new WordBreak();
    boolean b = wordBreak.wordBreak(str, list);
    System.out.println(b);
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] valid = new boolean[s.length() + 1];
    valid[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (wordDict.contains(s.substring(j, i)) && valid[j]) {
          valid[i] = true;
        }
      }
    }

    return valid[s.length()];
  }

  public boolean wordBreak2(String s, List<String> wordDict) {
    int start = 0;
    int prev = 1;
    while (prev <= s.length()) {
      String s1 = s.substring(start, prev);
      if (wordDict.contains(s1)) {
        start = prev;
//        prev += 1;
      }
      prev++;
    }
    return start == s.length();
  }

}
