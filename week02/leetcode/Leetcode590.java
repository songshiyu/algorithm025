//给定一个 N 叉树，返回其节点值的 后序遍历 。
//N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @@author songshiyu n叉树的后序遍历
 * @create: 2021/4/8 09:29:50
 **/
public class Leetcode590 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 递归方式实现N叉树的后续遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorder(result, root);
        return result;
    }

    public void postorder(List<Integer> result, Node node) {
        if (node == null) return;
        List<Node> childrens = node.children;
        for (int i = 0; i < childrens.size(); i++) {
            postorder(result, childrens.get(i));
        }
        result.add(node.val);
    }

    /**
     * 迭代方式实现N叉树的后续遍历 TODO
     *
     * @param root
     * @return
     */
    public List<Integer> postorder2(Node root) {
        return null;
    }
}
