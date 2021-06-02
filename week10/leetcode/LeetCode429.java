import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: N叉树的层序遍历
 * @create: 2021/6/1 10:41:18
 **/
public class LeetCode429 {

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

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Node> nodes = Arrays.asList(root);
        if (!nodes.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<Node> nodeList = new ArrayList<>();
            for (Node node : nodes) {
                list.add(node.val);
                nodeList.addAll(node.children);
            }
            result.add(list);
            nodes = nodeList;
        }
        return result;
    }
}
