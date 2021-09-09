package string;

import java.util.HashSet;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/9/9 16:53
 * @description
 *
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jewels-and-stones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumJewelsInStones {

  public static void main(String[] args) {
    String str1 = "aA";
    String str2 = "aAAbbbb";
    NumJewelsInStones numJewelsInStones = new NumJewelsInStones();
    int i = numJewelsInStones.numJewelsInStones(str1, str2);
    System.out.println(i);

  }

  public int numJewelsInStones(String jewels, String stones) {
    HashSet<Object> set = new HashSet<>();
    int count = 0;
    for (int i = 0; i < jewels.length(); i++) {
      set.add(jewels.charAt(i));
    }

    for (int j = 0; j < stones.length(); j++) {
      if (set.contains(stones.charAt(j))) {
        count++;
      }
    }
    return count;
  }

}
