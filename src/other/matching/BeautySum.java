package other.matching;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/12 15:36
 * @description
 *
 * 一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
 *
 * 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
 * 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aabcb"
 * 输出：5
 * 解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。
 * 示例 2：
 *
 * 输入：s = "aabcbaa"
 * 输出：17
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-beauty-of-all-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BeautySum {

  public static void main(String[] args) {
    String aabcb = new String("aabcb");
    BeautySum beautySum = new BeautySum();
    long l = System.currentTimeMillis();

    int i = beautySum.beautySum2(aabcb);

    System.out.println(System.currentTimeMillis()-l);
    System.out.println("i："+i);
  }

  public int beautySum(String s) {
    if (s.equals("") || s.length() == 1) {
      return 0;
    }
    //1.求出s的所有子字符串
    int head = 0;
    int prev = head + 1;
    int beauty = 0;
    do {
      //2.计算字符串的美丽值,然后相加
      if (prev-head > 2) {
        String str = s.substring(head, prev);
        int max = 1;
        int min = -1;
//        HashMap<Character, Integer> map = new HashMap<>();
        int[] count = new int[26];
        //用于遍历子字符串的存储
        for (int i = 0; i < str.length(); i++) {
          count[str.charAt(i) - 'a'] += 1;
//          if (map.containsKey(str.charAt(i))) {
//            Integer integer = map.get(str.charAt(i));
//            integer += 1;
//            if (integer > max) {
//              max = integer;
//            }
//            map.put(str.charAt(i), integer);
//          } else {
//            map.put(str.charAt(i), 1);
//          }
        }
        for (Integer value:count) {
          if (value > 0 && value > max) {
            max = value;
          }
          if ((value != 0 && min == -1) || (value>0 && min>value)) {
            min = value;
          }
        }
//        for (Character key: map.keySet()) {
//          if (map.get(key) < min || min == 0) {
//            min = map.get(key);
//          }
//        }
        beauty += (max - min);
      }
      //prev已经是最后一个,开始移动head并且重置prev
      if (prev >= s.length()) {
        head++;
        if (head + 1 > s.length()) {break;}
        prev = head;
      }
        prev += 1;
    } while (prev > head);
    return beauty;
  }

  public int beautySum2(String s) {
    if (s.equals("") || s.length() == 1) {
      return 0;
    }
    //1.求出s的所有子字符串
    int head = 0;
    int prev = head + 1;
    int beauty = 0;
    do {
      //2.计算字符串的美丽值,然后相加
      if (prev-head > 2) {
        String str = s.substring(head, prev);
        int max = 1;
        int min = -1;
        int[] count = new int[26];
        //用于遍历子字符串的存储
        for (int i = 0; i < str.length(); i++) {
          count[str.charAt(i) - 'a'] += 1;
        }
        for (Integer value:count) {
          if (value > 0 && value > max) {
            max = value;
          }
          if ((value != 0 && min == -1) || (value>0 && min>value)) {
            min = value;
          }
        }
        beauty += (max - min);
      }
      //prev已经是最后一个,开始移动head并且重置prev
      if (prev >= s.length()) {
        head++;
        if (head + 1 > s.length()) {break;}
        prev = head;
      }
      prev += 1;
    } while (prev > head);
    return beauty;
  }
}
