import java.util.ArrayList;
import java.util.List;

/**
 * @author songshiyu 深度优先搜索 TODO
 * @create: 2021/4/19 08:48:38
 **/
public class DFS {

    public class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {

        }

        public TreeNode(int value) {
            this.val = value;
        }
    }

    /**
     * 递归写法
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        levelOrder(result, 0, root);
        return result;
    }

    private void levelOrder(List<List<Integer>> result, int level, TreeNode node) {
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);

        if (node.left != null) {
            levelOrder(result, level + 1, node.left);
        }

        if (node.right != null) {
            levelOrder(result, level + 1, node.right);
        }
    }

    /**
     * 非递归写法
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        return null;
    }
}
