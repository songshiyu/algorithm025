import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author songshiyu 二叉树的层序遍历
 * @create: 2021/4/23 09:10:34
 **/
public class LeetCode102_2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 使用DFS深度优先搜索
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        DFS(root, result, 1);
        return result;
    }

    public void DFS(TreeNode node, List<List<Integer>> result, int level) {

        if (result.size() < level) {
            result.add(new ArrayList<>());
        }

        result.get(level - 1).add(node.val);

        if (node.left != null) {
            DFS(node.left, result, level + 1);
        }

        if (node.right != null) {
            DFS(node.right, result, level + 1);
        }
    }

    /**
     * 使用BFS 广度优先搜索 + 队列
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> element = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                element.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(element);
        }
        return result;
    }
}
