import java.util.*;

public class KthLargestInBST {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }

    private static TreeNode buildTree(Integer[] values) {
        if (values.length == 0 || values[0] == -1) return null;
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (i < values.length) {
            TreeNode current = queue.poll();
            if (values[i] != -1) {
                current.left = new TreeNode(values[i]);
                queue.add(current.left);
            }
            i++;
            if (i < values.length && values[i] != -1) {
                current.right = new TreeNode(values[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    static class Counter {
        int count = 0;
        int result = -1;
    }

    private static void reverseInorder(TreeNode root, int k, Counter counter) {
        if (root == null || counter.count >= k) return;

        reverseInorder(root.right, k, counter);

        counter.count++;
        if (counter.count == k) {
            counter.result = root.val;
            return;
        }

        reverseInorder(root.left, k, counter);
    }

    public static int findKthLargest(TreeNode root, int k) {
        Counter counter = new Counter();
        reverseInorder(root, k, counter);
        return counter.result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        while (T-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            String[] input = sc.nextLine().split(" ");
            Integer[] nodes = new Integer[n];

            for (int i = 0; i < n; i++) {
                nodes[i] = Integer.parseInt(input[i]);
            }

            int k = Integer.parseInt(sc.nextLine());

            TreeNode root = buildTree(nodes);
            System.out.println(findKthLargest(root, k));
        }
    }
}
