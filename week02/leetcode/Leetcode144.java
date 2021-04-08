import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @@author songshiyu 二叉树的前序遍历
 * @create: 2021/4/7 12:41:29
 **/
public class Leetcode144 {

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

        /**
         * 递归解题
         *
         * @param root
         * @return
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            preorderTraversal(result, root);
            return result;
        }

        public void preorderTraversal(List<Integer> result, TreeNode node) {

            if (node == null) {
                return;
            }
            result.add(node.val);
            preorderTraversal(result, node.left);
            preorderTraversal(result, node.right);
        }

        /**
         * 题解--迭代方式
         *
         * @param root
         * @return
         */
        public List<Integer> preorderTraversal2(TreeNode root) {

            List<Integer> result = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();

            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    result.add(root.val);
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                root = root.right;
            }
            return result;
        }
    }
}
