import java.util.*;

/**
 * @description: N叉树的前序遍历
 * @create: 2021/5/13 09:50:01
 **/
public class LeetCode589 {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return result;
        }

        result.add(root.val);
        List<Node> childrens = root.children;

        for (Node child : childrens) {
            preorder(child);
        }
        return result;
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {
        LinkedList<Node> queue = new LinkedList<>();

        if (root == null) {
            return new ArrayList<>();
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            result.add(node.val);
            List<Node> childrens = node.children;
            //若想将children按顺序放入队列内，需要将childrens集合翻转
            Collections.reverse(childrens);
            for (Node children : childrens) {
                queue.addFirst(children);
            }
        }
        return result;
    }


}

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
