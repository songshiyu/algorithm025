import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author songshiyu N 叉树的层序遍历
 * @date 2021/4/11 16:27
 **/
public class LeetCode429LevelOrder {

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
     * 递归方式
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(result, root, 0);
        return result;
    }

    public void levelOrder(List<List<Integer>> resut, Node node, int level) {

        if (resut.size() <= level) {
            resut.add(new ArrayList<>());
        }
        resut.get(level).add(node.val);
        List<Node> childrens = node.children;
        for (Node child : childrens) {
            levelOrder(resut, child, level + 1);
        }
    }

    /**
     * 迭代方式
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Node> previousNode = Arrays.asList(root);

        while (!previousNode.isEmpty()) {
            List<Node> currentNode = new ArrayList<>();
            List<Integer> previousVals = new ArrayList<>();
            for (Node node : previousNode) {
                previousVals.add(node.val);
                currentNode.addAll(node.children);
            }
            result.add(previousVals);
            previousNode = currentNode;
        }

        return result;
    }

}
