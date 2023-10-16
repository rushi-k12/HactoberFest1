import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class ZigzagTraversal {

    public List<List<Integer>> zigzagTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean zigzag = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            // Use a stack to reverse the order for zigzag traversal
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (zigzag) {
                    currentLevel.add(node.val);
                } else {
                    stack.push(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Add nodes from the stack to the current level in reverse order
            while (!stack.isEmpty()) {
                currentLevel.add(stack.pop());
            }

            result.add(currentLevel);
            zigzag = !zigzag;
        }

        return result;
    }
