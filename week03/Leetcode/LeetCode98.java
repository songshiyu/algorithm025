import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songshiyu  验证二叉搜索树
 * 由于二叉搜索树的中序遍历是有序的，因此可用中序遍历来验证二叉搜索树
 * @create: 2021/4/13 08:36:15
 **/
public class LeetCode98 {

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

    long preValue = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (root.val <= preValue) {
            return false;
        }
        preValue = root.val;
        return isValidBST(root.right);
    }
}
