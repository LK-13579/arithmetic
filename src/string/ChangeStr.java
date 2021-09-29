package string;

import java.util.Arrays;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/9/29 14:45
 * @description
 */
public class ChangeStr {

  public static void main(String[] args) {
    ChangeStr changeStr = new ChangeStr();
    String str = "abc123def";
    String replace = changeStr.replace(str, 3);
    System.out.println(replace.toString());
    System.out.println('*' * 5);
  }

  public String replace(String str, int num) {
    if (str == null || num == 0) {
      return str;
    }

    int start = (str.length() - num) / 2;

    char[] array = str.toCharArray();

    for (int i = start; i < start + num; i++) {
      array[i] = '*';
    }
    return new String(array);
  }
}
