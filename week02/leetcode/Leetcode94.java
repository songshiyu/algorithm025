//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
//输入：root = [1,null,2,3]
//        输出：[1,3,2]


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @@author songshiyu 二叉树的中序遍历
 * @create: 2021/4/7 12:16:25
 **/
public class Leetcode94 {

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
     * 递归方式解题
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        inorderTraversal(result, root);
        return result;
    }

    public void inorderTraversal(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(result, node.left);
        result.add(node.val);
        inorderTraversal(result, node.right);
    }

    /**
     * 迭代方式解题 -- 需要用到栈来存储
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

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
