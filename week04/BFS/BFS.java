import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author songshiyu 广度优先搜索
 * @create: 2021/4/21 08:09:32
 **/
public class BFS {

    public class TreeNode {

        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 利用队列先入先出的特性，将每一层的元素存入队列，然后在依次取出
     * 可以用来实现二叉树的层序遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> bfs(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> elements = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                elements.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            result.add(elements);
        }
        return result;
    }
}
