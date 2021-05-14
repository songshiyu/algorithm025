//一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
//给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
//开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
//如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
//
//        示例 1：
//        输入：stones = [0,1,3,5,6,8,12,17]
//        输出：true
//        解释：青蛙可以成功过河，按照如下方案跳跃：跳 1 个单位到第 2 块石子, 然后跳 2 个单位到第 3 块石子, 接着 跳 2 个单位到第 4 块石子, 然后跳 3 个单位到第 6 块石子, 跳 4 个单位到第 7 块石子, 最后，跳 5 个单位到第 8 个石子（即最后一块石子）。
//
//        示例 2：
//        输入：stones = [0,1,2,3,4,8,9,11]
//        输出：false
//        解释：这是因为第 5 和第 6 个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。
//
//        提示：
//        2 <= stones.length <= 2000
//        0 <= stones[i] <= 231 - 1
//        stones[0] == 0


import java.util.HashMap;
import java.util.Map;

/**
 * @description: 青蛙过河
 * @create: 2021/5/13 15:14:18
 **/
public class LeetCode403 {

    /**
     * DFS + 记忆化搜索
     *
     * @param stones
     * @return
     */
    Map<Integer, Integer> map = new HashMap<>();
    Map<String, Boolean> memory = new HashMap<>();

    public boolean canCross(int[] stones) {
        int n = stones.length;

        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }
        //题目描述中，第一步只能跳一步
        if (!map.containsKey(1)) return false;
        return dfs(stones, stones.length, 1, 1);
    }

    /**
     * @param stones 石子位置列表
     * @param length 石子长度
     * @param index  当前所在的石子下标
     * @param step   上一次经过多少步跳到此位置
     * @return
     */
    private boolean dfs(int[] stones, int length, int index, int step) {
        String key = index + "_" + step;
        if (memory.containsKey(key)) {
            return memory.get(key);
        }
        if (index == length - 1) {
            return true;
        }
        for (int i = -1; i <= 1; i++) {
            //原地踏步
            if (step + i == 0) continue;
            //理论上下一个石子的编号
            int next = stones[index] + step + i;
            if (map.containsKey(next)) {
                boolean dfs = dfs(stones, length, map.get(next), step + i);
                memory.put(key, dfs);
                if (dfs) return true;
            }
        }
        memory.put(key, false);
        return false;
    }

    /**
     * DP:
     * dp[n][n] = dp[n-1][j] &&
     *
     * @param stones
     * @return
     */
    public boolean canCross2(int[] stones) {
        int n = stones.length;
        // check first step
        if (stones[1] != 1) return false;
        boolean[][] f = new boolean[n + 1][n + 1];
        f[1][1] = true;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                int k = stones[i] - stones[j];
                // 我们知道从位置 j 到位置 i 是需要步长为 k 的跳跃

                // 而从位置 j 发起的跳跃最多不超过 j + 1
                // 因为每次跳跃，下标至少增加 1，而步长最多增加 1
                if (k <= j + 1) {
                    f[i][k] = f[j][k - 1] || f[j][k] || f[j][k + 1];
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (f[n - 1][i]) return true;
        }
        return false;
    }

}
