package arraylist;

/**
 * ClassName: arraylist Package 二堆数组 Description Author zwang2654
 *
 * @Create 3/7/2023 2:49 PM
 * @Version 1.0
 */
public class arraylist {
  public static void main(String[] args) {
    int[][] arr = { {1, 2, 8, 9},
        {2, 4, 9, 12},
        {4, 7, 10, 13},
        {6, 8, 11, 15} };

    System.out.println(Solution.Find(7, arr));
  }

  public class Solution {
    public static boolean Find(int target, int[][] matrix) {
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        return false;
      int rows = matrix.length, cols = matrix[0].length;
      int r = 0, c = cols - 1; // 从右上角开始
      while (r <= rows - 1 && c >= 0) {
        if (target == matrix[r][c])
          return true;
        else if (target > matrix[r][c])
          r++;
        else
          c--;
      }
      return false;
    }
  }

}
