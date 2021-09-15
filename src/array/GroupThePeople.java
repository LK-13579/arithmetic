package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/9/15 10:17
 * @description 有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，每位用户都 恰好 属于某一用户组。给你一个长度为 n
 * 的数组 groupSizes，其中包含每位用户所处的用户组的大小，请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。
 * <p>
 * 你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：groupSizes = [3,3,3,3,3,1,3] 输出：[[5],[0,1,2],[3,4,6]] 解释： 其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和
 * [[5],[0,6,2],[4,3,1]]。 示例 2：
 * <p>
 * 输入：groupSizes = [2,1,3,3,3,2] 输出：[[1],[0,5],[2,3,4]]
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/group-the-people-given-the-group-size-they-belong-to
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GroupThePeople {

  public static void main(String[] args) {
    int[] arr = {3,3,3,3,3,1,3};
    GroupThePeople people = new GroupThePeople();
    List<List<Integer>> lists = people.groupThePeople(arr);
    lists.forEach(x -> System.out.println(x));
  }

  public List<List<Integer>> groupThePeople(int[] groupSizes) {
//    int[][] arr = new int[groupSizes.length][groupSizes.length];
    List<List<Integer>> result = new ArrayList<>();
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < groupSizes.length; i++) {
      int data = groupSizes[i];
      List<Integer> list = map.get(data);
      if (list == null) {
        list = new ArrayList<>();
      }
      list.add(i);
      map.put(data, list);
      if (list.size() == data) {
        //等于特定长度的时候移除
        result.add(map.get(data));
        map.remove(data);
      }

    }
    return result;
  }



  public List<List<Integer>> groupThePeople2(int[] groupSizes) {
    Arrays.sort(groupSizes);
    List<List<Integer>> result = new ArrayList<>();
    int tmp = 0;
    for (int i = 0; i < groupSizes.length - 1; i += tmp) {
      ArrayList<Integer> list = new ArrayList<>(groupSizes[i]);
      int j = i;
      while (list.size() < groupSizes[j]) {
        tmp = groupSizes[j];
        list.add(groupSizes[i]);
      }
      result.add(list);
    }
    return result;
  }

}
