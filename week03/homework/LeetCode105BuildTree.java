//根据一棵树的前序遍历与中序遍历构造二叉树。
//        注意:
//        你可以假设树中没有重复的元素。
//        例如，给出
//        前序遍历 preorder = [3,9,20,15,7]
//        中序遍历 inorder = [9,3,15,20,7]

import java.util.Arrays;

/**
 * @author songshiyu 从前序与中序遍历序列构造二叉树
 * @date 2021/4/17 08:49
 **/
public class LeetCode105BuildTree {

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
     * 1.根据前序遍历来确定根节点的索引
     * 2.然后可在中序遍历中，确定左右子树
     * 3.递归1，2两步，即可构造出一颗树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] preRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);

                int[] inLeft = Arrays.copyOfRange(inorder, 0, i + 1);
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                root.left = buildTree(preLeft, inLeft);
                root.right = buildTree(preRight, inRight);
                break;
            }
        }
        return root;
    }
}
