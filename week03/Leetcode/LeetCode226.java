
/**
 * @author songshiyu  翻转二叉树 左子树和右子树交换
 * @create: 2021/4/13 08:04:26
 **/
public class LeetCode226 {

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
     * 递归：自己实现的交换某节点左右子节点
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root, root.left, root.right);
        return root;
    }

    public void invertTree(TreeNode node, TreeNode left, TreeNode right) {
        if (node == null) {
            return;
        }
        if (node.left != null && node.right != null) {
            invertTree(left, left.left, left.right);
            invertTree(right, right.left, right.right);
        } else if (node.left != null && node.right == null) {
            invertTree(left, left.left, left.right);
        } else if (node.left == null && node.right != null) {
            invertTree(right, right.left, right.right);
        }
        node.right = left;
        node.left = right;
    }

    /**
     * 参照leetcode优质回答
     *
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);

        root.left = right;
        root.right = left;
        return root;
    }
}
