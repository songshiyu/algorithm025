//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//   每行中的整数从左到右按升序排列。
//   每行的第一个整数大于前一行的最后一个整数。
//
//        示例 1：
//        输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//        输出：true
//
//        示例 2：
//        输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//        输出：false
//
//        提示：
//        m == matrix.length
//        n == matrix[i].length
//        1 <= m, n <= 100
//        -104 <= matrix[i][j], target <= 104

/**
 * @description: 搜索二维矩阵
 * @create: 2021/5/8 10:30:49
 **/
public class LeetCode74 {

    public boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][matrix[i].length - 1]) {
                //此步可用二分查找，速度会更快
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
