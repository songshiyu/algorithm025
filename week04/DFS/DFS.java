import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author songshiyu 深度优先搜索
 * @create: 2021/4/21 08:30:02
 **/
public class DFS {

    public class TreeNode {

        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 手动维护一个队列完成DFS
     *
     * @param root
     * @return
     */
    public List<Integer> dfs(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }

            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return result;
    }

    /**
     * 使用递归的方式完成DFS，其实相当于系统帮我们维护了一个栈来存储元素
     *
     * @param root
     * @return
     */
    public List<Integer> dfsR(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        solve(result, root);
        return result;
    }

    private void solve(List<Integer> result, TreeNode node) {

        if (node == null) {
            return;
        }

        result.add(node.val);
        if (node.left != null) {
            solve(result, node.left);
        }

        if (node.right != null) {
            solve(result, node.right);
        }
    }

    /**
     * 使用DFS实现二叉树的层序遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        levelOrder(result, root, 1);
        return result;
    }

    private void levelOrder(List<List<Integer>> result, TreeNode node, int level) {

        if (result.size() < level) {
            result.add(new ArrayList<>());
        }

        result.get(level - 1).add(node.val);
        if (node.left != null) {
            levelOrder(result, node.left, level + 1);
        }

        if (node.right != null) {
            levelOrder(result, node.right, level + 1);
        }
    }
}
