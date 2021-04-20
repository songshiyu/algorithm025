//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//        示例：
//        二叉树：[3,9,20,null,null,15,7],
//        3
//        / \
//       9  20
//          /  \
//         15   7
//        返回其层序遍历结果：
//
//        [
//        [3],
//        [9,20],
//        [15,7]
//        ]

import java.util.ArrayList;
import java.util.List;

/**
 * @author songshiyu 二叉树的层序遍历
 * @create: 2021/4/20 08:40:17
 **/
public class LeetCode102 {

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

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(root, result, 1);
        return result;
    }

    private void levelOrder(TreeNode node, List<List<Integer>> result, int level) {

        if (result.size() < level) {
            result.add(new ArrayList<>());
        }

        result.get(level - 1).add(node.val);

        if (node.left != null) {
            levelOrder(node.left, result, level + 1);
        }

        if (node.right != null) {
            levelOrder(node.right, result, level + 1);
        }

    }
}
