import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 从前序与中序遍历序列构造二叉树
 * @create: 2021/6/4 14:40:30
 **/
public class LeetCode105 {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        if (p_start == p_end) {
            return null;
        }
        int rootValue = preorder[p_start];
        TreeNode root = new TreeNode(rootValue);

        int rootInInOrder = -1;
        for (int i = i_start; i < i_end; i++) {
            if (inorder[i] == rootValue) {
                rootInInOrder = i;
                break;
            }
        }

        int leftNums = rootInInOrder - i_start;
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + 1 + leftNums, inorder, i_start, rootInInOrder);
        root.right = buildTreeHelper(preorder, p_start + 1 + leftNums, p_end, inorder, rootInInOrder + 1, i_end);
        return root;
    }

}
