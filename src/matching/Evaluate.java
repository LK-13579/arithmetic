package matching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/5 9:51
 * @description 给你一个字符串 s ，它包含一些括号对，每个括号中包含一个 非空 的键。
 * <p>
 * 比方说，字符串 "(name)is(age)yearsold" 中，有 两个 括号对，分别包含键 "name" 和 "age" 。
 * 你知道许多键对应的值，这些关系由二维字符串数组 knowledge 表示，其中 knowledge[i] = [keyi, valuei] ，表示键 keyi 对应的值为 valuei 。
 * <p>
 * 你需要替换 所有 的括号对。当你替换一个括号对，且它包含的键为 keyi 时，你需要：
 * <p>
 * 将 keyi 和括号用对应的值 valuei 替换。 如果从 knowledge 中无法得知某个键对应的值，你需要将 keyi 和括号用问号 "?" 替换（不需要引号）。
 * knowledge 中每个键最多只会出现一次。s 中不会有嵌套的括号。
 * <p>
 * 请你返回替换 所有 括号对后的结果字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]] 输出："bobistwoyearsold"
 * 解释： 键 "name" 对应的值为 "bob" ，所以将 "(name)" 替换为 "bob" 。 键 "age" 对应的值为 "two" ，所以将 "(age)" 替换为 "two" 。
 * 示例 2：
 * <p>
 * 输入：s = "hi(name)", knowledge = [["a","b"]] 输出："hi?" 解释：由于不知道键 "name" 对应的值，所以用 "?" 替换 "(name)" 。
 * 示例 3：
 * <p>
 * 输入：s = "(a)(a)(a)aaa", knowledge = [["a","yes"]] 输出："yesyesyesaaa" 解释：相同的键在 s 中可能会出现多次。 键 "a"
 * 对应的值为 "yes" ，所以将所有的 "(a)" 替换为 "yes" 。 注意，不在括号里的 "a" 不需要被替换。 示例 4：
 * <p>
 * 输入：s = "(a)(b)", knowledge = [["a","b"],["b","a"]] 输出："ba"
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/evaluate-the-bracket-pairs-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Evaluate {

  public static void main(String[] args) {
    String str = "(name)is(age)yearsold";
    List<List<String>> list = new ArrayList<>();
    List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    list1.add("name");
    list1.add("bob");
    list2.add("age");
    list2.add("two");
    list.add(list1);
    list.add(list2);
    Evaluate evaluate = new Evaluate();
    String result = evaluate.evaluate(str, list);
    System.out.println(result);
  }

  public String evaluate(String s, List<List<String>> knowledge) {
    //将对应的键值转换成map存储
    HashMap<String, String> map = new HashMap<>();
    for (List<String> list : knowledge) {
      map.put(list.get(0), list.get(1));
    }
    int start = -1;
    do {
      start = s.indexOf("(");
      int end = s.indexOf(")");
      if (start != -1 && end != -1) {
        String key = s.substring(start + 1, end);
        String s1 = map.get(key);
        if (s1 != null) {
          s = s.replace("(".concat(key).concat(")"), s1);
        } else {
          s = s.replace("(".concat(key).concat(")"), "?");
        }
      }
      start = s.indexOf("(");
    } while (start >= 0);

    return s;
  }
}
