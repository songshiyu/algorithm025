import java.util.*;

/**
 * @author songshiyu N叉树的前序遍历
 * @date 2021/4/10 15:37
 **/
public class LeetCode589Preorder {

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
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preorder(result, root);
        return result;
    }

    public void preorder(List<Integer> result, Node node) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        List<Node> childrens = node.children;
        for (Node node1 : childrens) {
            preorder(result, node1);
        }
    }

    /**
     * 迭代:需要用到双向队列来辅助
     *
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {

        List<Integer> result = new ArrayList<>();
        LinkedList<Node> linkedList = new LinkedList<>();

        if (root == null) {
            return new ArrayList<>();
        }
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            Node node = linkedList.pollLast();
            result.add(node.val);
            List<Node> childrens = node.children;
            //若想将children按顺序放入队列内，需要将childrens集合翻转
            Collections.reverse(childrens);
            for (Node children : childrens) {
                linkedList.add(children);
            }
        }
        return result;
    }


}
