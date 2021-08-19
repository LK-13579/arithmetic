package array;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/19 9:59
 * @description 给你一个 m * n 的网格，其中每个单元格不是 0（空）就是 1（障碍物）。每一步，您都可以在空白单元格中上、下、左、右移动。
 * <p>
 * 如果您 最多 可以消除 k 个障碍物，请找出从左上角 (0, 0) 到右下角 (m-1, n-1) 的最短路径，并返回通过该路径所需的步数。如果找不到这样的路径，则返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入： grid = [[0,0,0],  [1,1,0], [0,0,0],  [0,1,1], [0,0,0]], k = 1 输出：6 解释： 不消除任何障碍的最短路径是 10。 消除位置
 * (3,2) 处的障碍后，最短路径是 6 。该路径是 (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).  
 * <p>
 * 示例 2：
 * <p>
 * 输入： grid = [[0,1,1],  [1,1,1],  [1,0,0]], k = 1 输出：-1 解释： 我们至少需要消除两个障碍才能找到这样的路径。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/shortest-path-in-a-grid-with-obstacles-elimination
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortestPath {

  public static void main(String[] args) {
    int[][] grid = {{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}};
    ShortestPath shortestPath = new ShortestPath();
    shortestPath.shortestPath(grid, 0);
  }

  public int shortestPath(int[][] grid, int k) {
    int[][] result = new int[grid.length * grid[0].length][2];
    return search(grid, 0, 0, k, result, 0);
  }

  private static int search(int[][] grid, int m, int n, int k, int[][] result, int i) {
    if (m == grid.length - 1 && n == grid[m - 1].length - 1) {
      return result.length;
    }
    //路径总是从左开始遍历,从0开始
    if (n < grid[m].length - 1) {
//      int i = grid[m][n + 1] == 1 ? k-- : n++;
      if (grid[m][n + 1] != 1 && k >= 0) {
        result[i++] = new int[]{m, n};
        search(grid, m, n += 1, k, result, i);
      }
    }
    if (m < grid.length - 1) {
      //当已经到达最右边或路障已无法消除,则往下寻找
//      int i = grid[m + 1][n] == 1 ? k-- : m++;
      if (grid[m + 1][n] != 1 && k >= 0) {
        result[i++] = new int[]{m, n};
        search(grid, m += 1, n, k, result, i);
      }
    }
    if (n == grid[m].length - 1 && grid[m + 1][n] == 1 && k <= 0) {
//      int i = grid[m][n - 1] == 1 ? k-- : n--;
      if (grid[m][n - 1] != 1 && k >= 0) {
        result[i++] = new int[]{m, n};
        search(grid, m, n -= 1, k, result, i);
      }
    }
    return result.length;
  }
}
