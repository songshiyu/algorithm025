import java.util.*;

/**
 * @author songshiyu
 * @date 2021/4/11 16:14
 **/
public class LeetCode144PreorderTraversal {

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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            preorderTraversal(result, root);
            return result;
        }

        private void preorderTraversal(List<Integer> result, TreeNode node) {
            if (node == null) {
                return;
            }
            result.add(node.val);
            preorderTraversal(result, node.left);
            preorderTraversal(result, node.right);
        }

        /**
         * 迭代
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
