import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author songshiyu 二叉树的中序遍历
 * @date 2021/4/11 15:42
 **/
public class LeetCode94InorderTraversal {

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
         * 递归
         *
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            inorderTraversal(result, root);
            return result;
        }

        private void inorderTraversal(List<Integer> result, TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraversal(result, root.left);
            result.add(root.val);
            inorderTraversal(result, root.right);
        }

        /**
         * 迭代
         *
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal2(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
            return result;
        }
    }
}
