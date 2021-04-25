//机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
//        -2 ：向左转 90 度
//        -1 ：向右转 90 度
//        1 <= x <= 9 ：向前移动 x 个单位长度
//        在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
//        机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
//        返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
//         
//        注意：
//        北表示 +Y 方向。
//        东表示 +X 方向。
//        南表示 -Y 方向。
//        西表示 -X 方向。
//
//        示例 1：
//        输入：commands = [4,-1,3], obstacles = []
//        输出：25
//        解释：
//        机器人开始位于 (0, 0)：
//        1. 向北移动 4 个单位，到达 (0, 4)
//        2. 右转
//        3. 向东移动 3 个单位，到达 (3, 4)
//        距离原点最远的是 (3, 4) ，距离为 32 + 42 = 25
//
//        示例 2：
//        输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//        输出：65
//        解释：机器人开始位于 (0, 0)：
//        1. 向北移动 4 个单位，到达 (0, 4)
//        2. 右转
//        3. 向东移动 1 个单位，然后被位于 (2, 4) 的障碍物阻挡，机器人停在 (1, 4)
//        4. 左转
//        5. 向北走 4 个单位，到达 (1, 8)
//        距离原点最远的是 (1, 8) ，距离为 12 + 82 = 65

import java.util.HashSet;
import java.util.Set;

/**
 * @author songshiyu 模拟行走机器人
 * @create: 2021/4/25 08:21:55
 **/
public class LeetCode874RobotSim {

    /**
     * 思路：
     * 主要就是去判断每一步是否会经过障碍物，同时要考虑到移动方向
     *
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        //将在x,y轴的四个方向上的移动用数组表示 北西南东
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //按题意定义初始时机器人位置、方向及欧式距离
        int result = 0, direction = 0, x = 0, y = 0;
        //将障碍物坐标放在Set集合中，方面对机器人的每一步进行判断是否会经过障碍物
        Set<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + "_" + obstacle[1]);
        }
        for (int i = 0; i < commands.length; i++) {
            int command = commands[i];
            if (command > 0) {
                //开始移动
                for (int c = 0; c < command; c++) {
                    int next_x = x + directions[direction][0];
                    int next_y = y + directions[direction][1];
                    if (set.contains(next_x + "_" + next_y)) {
                        break;
                    } else {
                        x = next_x;
                        y = next_y;
                        result = Math.max(result, x * x + y * y);
                    }
                }
            } else {
                //机器人移动方向,由于direction经过若干次变换后，可能在0-3范围
                direction = command == -1 ? (direction + 1) % 4 : (direction + 3) % 4;
            }
        }
        return result;
    }
}
