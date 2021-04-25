import java.util.Arrays;

/**
 * @author songshiyu  分发饼干
 * @create: 2021/4/25 08:14:05
 **/
public class LeetCode455FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        //首先将孩子的胃口与饼干的大小进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0, cookie = 0;
        while (child < g.length && cookie < s.length) {
            //若当前饼干满足此孩子胃口，则饼干和孩子索引后移
            if (g[child] <= s[cookie]) {
                cookie++;
                child++;
            } else {
                cookie++;
            }
        }
        return child;
    }
}
