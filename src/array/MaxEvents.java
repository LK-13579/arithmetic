package array;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/30 10:49
 * @description 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
 * <p>
 * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。
 * <p>
 * 请你返回你可以参加的 最大 会议数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：events = [[1,2],[2,3],[3,4]] 输出：3 解释：你可以参加所有的三个会议。 安排会议的一种方案如上图。 第 1 天参加第一个会议。 第 2 天参加第二个会议。 第
 * 3 天参加第三个会议。 示例 2：
 * <p>
 * 输入：events= [[1,2],[2,3],[3,4],[1,2]] 输出：4 示例 3：
 * <p>
 * 输入：events = [[1,4],[4,4],[2,2],[3,4],[1,1]] 输出：4 示例 4：
 * <p>
 * 输入：events = [[1,100000]] 输出：1 示例 5：
 * <p>
 * 输入：events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]] 输出：7
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-number-of-events-that-can-be-attended
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxEvents {

  public static void main(String[] args) {
    MaxEvents maxEvents = new MaxEvents();
    int[][] arr = {{52, 79}, {7, 34}};
    int i = maxEvents.maxEvents(arr);
    System.out.println(i);
  }

  public int maxEvents(int[][] events) {
    //将二维数组问题转化成一维数组
    int[] days = new int[events.length+1];
    int day = 0;
    for (int i = 0; i < events.length; i++) {
      int[] ints = events[i];
      int i1 = ints[0];
      int i2 = ints[1];
      for (int j = i1; j <= i2; j++) {
        if (j < days.length) {
          days[j]++;
        }
      }
    }
    for (int i = 0; i < events.length; i++) {
      int[] event = events[i];
      //标识下标
      int min = 0;
      for (int j = event[0]; j <= event[1]; j++) {
        //当min为0时,赋值第一个元素给min
        if (min == 0 && days[j] != 0) {
          min = j;
        }
        if (j<days.length && days[j] < days[min]) {
          min = j;
        }
      }
      if (min != 0) {
        days[min] = 0;
        day++;
      }
    }
    return day;
  }


  public int maxEvents2(int[][] events) {
    //下标用来标识天数,值用来标识是否参加会议0未安排,1已安排
    int[] days = new int[events.length];
    //返回的天数
    int day = 0;
    //1.优先处理只有在特定日期内完成的例如[1,1]
    for (int i = 0; i < events.length; i++) {
      int[] event = events[i];
      if (event[0] == event[1]) {
        days[event[0]] = 1;
        day++;
      }
      for (int j = 0; j < event.length - 1; j++) {
        if (days[event[j]] == 1) {
          continue;
        }
        days[event[j]] = 1;
        day++;
      }
    }
    return day;
  }
}
