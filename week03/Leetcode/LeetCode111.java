/**
 * @author songshiyu 二叉树的最小深度
 * @create: 2021/4/13 09:37:17
 **/
public class LeetCode111 {

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
     * 二叉树的最小深度和最大深度有所不同：
     * 需要进行区分根节点左右子树是否为空。
     * 若左子树/右子树为空，则返回非空树的深度
     * 若左子树/右子树都为空，则返回1
     * 若左子树/右子树都不为空，则返回两棵子树中较小的深度
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = minDepth(root.left);
            int rightDepth = minDepth(root.right);
//            if (root.left == null || root.right == null) {
//                return leftDepth + rightDepth + 1;
//            }
//            return Math.min(leftDepth, rightDepth) + 1;
            return (root.left == null || root.right == null) ? leftDepth + rightDepth + 1 : Math.min(leftDepth, rightDepth) + 1;
        }
    }
}
