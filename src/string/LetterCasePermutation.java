package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/17 16:48
 * @description 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * <p>
 *  
 * <p>
 * 示例： 输入：S = "a1b2" 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 输入：S = "3z4" 输出：["3z4", "3Z4"]
 * <p>
 * 输入：S = "12345" 输出：["12345"]  
 * <p>
 * 提示：
 * <p>
 * S 的长度不超过12。 S 仅由数字和字母组成。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCasePermutation {

  public static void main(String[] args) {
    //abc,abC,aBc,aBC
    //Abc,AbC,ABc,ABC
    LetterCasePermutation permutation = new LetterCasePermutation();
    String str = "O9";
    permutation.letterCasePermutation(str);
  }

  public List<String> letterCasePermutation(String s) {
    char[] chars = s.toCharArray();
    char[] chars1 = new char[chars.length];
    HashSet<String> list = new HashSet<>();
    hashNext2(chars, 0, list);
    System.out.println(list);
    return new ArrayList<>(list);
  }

  private static void hashNext2(char[] arr, int i, HashSet<String> list) {
    if (i >= arr.length) {
      list.add(new String(arr));
      if (arr[i - 1] - 'a' >= 0) {
        arr[i - 1] = (char) (arr[i - 1] - 32);
      } else if (arr[i - 1] - '9' <= 0) {
        return;
      } else {
        arr[i - 1] = (char) (arr[i - 1] + 32);
      }
      list.add(new String(arr));
      return;
    }
    if (i <= arr.length) {
      hashNext2(arr, i + 1, list);
      if (i != 0 && arr[i - 1] - 'a' >= 0) {
        arr[i - 1] = (char) (arr[i - 1] - 32);
        hashNext2(arr, i + 1, list);
      } else if (i != 0 && arr[i - 1] - '9' <= 0) {
        return;
      } else if (i != 0 && arr[i - 1] - 'a' < 0) {
        arr[i - 1] = (char) (arr[i - 1] + 32);
        hashNext2(arr, i + 1, list);
      }
    }
//    return ;
  }

  /**
   * @param arr 数组
   * @param i   位置i
   *
   * @return
   */
  private static boolean hashNext(char[] arr, int i, char[] tmp, ArrayList<String> list) {
    if (i >= arr.length) {
      list.add(new String(tmp));
      if (tmp[i - 1] - 'a' >= 0) {
        tmp[i - 1] = (char) (tmp[i - 1] - 32);
        list.add(new String(tmp));
      } else if (tmp[i - 1] - '9' <= 0) {
        return true;
      } else {
        tmp[i - 1] = (char) (tmp[i - 1] + 32);
        list.add(new String(tmp));
      }
      return false;
    }
    tmp[i] = arr[i];
    if (i <= arr.length) {
      hashNext(arr, i + 1, tmp, list);
      if (i != 0 && tmp[i - 1] - 'a' >= 0) {
        tmp[i - 1] = (char) (tmp[i - 1] - 32);
        hashNext(arr, i + 1, tmp, list);
      } else if (i != 0 && tmp[i - 1] - '9' <= 0) {
        return true;
      } else if (i != 0 && tmp[i - 1] - 'a' < 0) {
        tmp[i - 1] = (char) (tmp[i - 1] + 32);
        hashNext(arr, i + 1, tmp, list);
      }
    }
    return true;
  }

}
