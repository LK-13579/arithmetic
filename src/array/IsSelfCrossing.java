package array;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/9/8 11:51
 * @description
 *
 * 给定一个含有 n 个正数的数组 x。从点 (0,0) 开始，先向北移动 x[0] 米，然后向西移动 x[1] 米，向南移动 x[2] 米，向东移动 x[3] 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。
 *
 * 编写一个 O(1) 空间复杂度的一趟扫描算法，判断你所经过的路径是否相交。
 *
 *  
 *
 * 示例 1:
 *
 * ┌───┐
 * │   │
 * └───┼──>
 *     │
 *
 * 输入: [2,1,1,2]
 * 输出: true
 * 示例 2:
 *
 * ┌──────┐
 * │      │
 * │
 * │
 * └────────────>
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * ┌───┐
 * │   │
 * └───┼>
 *
 * 输入: [1,1,1,1]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/self-crossing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSelfCrossing {

  public static void main(String[] args) {
    IsSelfCrossing isSelfCrossing = new IsSelfCrossing();
    int[] arr = {2, 1, 1, 2};
    boolean selfCrossing = isSelfCrossing.isSelfCrossing(arr);
    System.out.println(selfCrossing);

  }

  public boolean isSelfCrossing(int[] distance) {
    if (distance.length<4)return true;
    //顺序已定,当数值大于4并且差值是非递增的即必定相交
    int dis0 = distance[0];
    int dis1 = distance[1];
    for (int i = 2; i < distance.length - 1; i++) {
      //分两种情况,第三根小于dis0情况
      if (dis0 > distance[i] && distance[i + 1] > dis1) {
        return true;
      } else {
        dis0 = distance[i];
        dis1 = distance[i + 1];
      }
    }
    return false;
  }

}
