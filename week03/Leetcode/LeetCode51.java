import java.util.ArrayList;
import java.util.List;

/**
 * @author songshiyu  N 皇后
 * @date 2021/4/13 20:31
 **/
public class LeetCode51 {

    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        solve(result, chess, 0);
        return result;
    }

    /**
     * @param result 结果集
     * @param chess  二维数组表示的n*n的棋盘
     * @param row    第几行
     */
    private void solve(List<List<String>> result, char[][] chess, int row) {
        if (row == chess.length) {
            result.add(transform2List(chess));
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            //判断第row行、第col列是否可以放入皇后
            if (isvalid(chess, row, col)) {
                chess[row][col] = 'Q';
                solve(result, chess, row + 1);
                //上一层递归返回后，将棋盘恢复原状，防止上一步递归产生污染
                chess[row][col] = '.';
            }
        }
    }

    /**
     * @param chess 二维数组表示的n*n的棋盘
     * @param row   第几行
     * @param col   第几列
     * @return
     */
    private boolean isvalid(char[][] chess, int row, int col) {
        //判断当前row行之前的col列有没有皇后,因为他是一行一行往下走的
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的右上角有无皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        //判断当前坐标左上角有无皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    /**
     * 将二维数组转换为List
     *
     * @param chess
     * @return
     */
    private List<String> transform2List(char[][] chess) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            solution.add(new String(chess[i]));
        }
        return solution;
    }
}
