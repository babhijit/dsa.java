package abhijit.learnitivity.dsa.leetcode.tree.binary.tree_from_pre_in_order_105.tree_from_pre_in_order_105;

import abhijit.learnitivity.dsa.tree.binary.TreeNode;

import static java.util.Objects.nonNull;

public class TreeFromPreInorderTraversals {
    private static final int ERROR_CODE = -1;

    private static class OrderRange {
        int low, high;
        int[] range;

        OrderRange(int low, int high, int[] range) {
            this.low = low;
            this.high = high;
            this.range = range;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        assert nonNull(preorder) && nonNull(inorder) : "both inorder and preorder must be non-null";
        assert preorder.length == inorder.length: "the lengths of preorder and inorder must match";

        OrderRange preorderRange = new OrderRange(0, preorder.length - 1, preorder);
        OrderRange inorderRange = new OrderRange(0, preorder.length - 1, inorder);

        return constructTree(preorder, preorderRange, inorder, inorderRange);
    }

    private TreeNode constructTree(int[] preorder, OrderRange preorderRange, int[] inorder, OrderRange inorderRange) {
        if (inorderRange.low > inorderRange.high) {
            return null;
        }

        if (preorderRange.low > preorderRange.high) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderRange.low]);
        int rootIndex = findInInorder(inorder, root.val, inorderRange.low, inorderRange.high);
        ++preorderRange.low;
        root.left = constructTree(preorder, preorderRange,
                                    inorder, new OrderRange(inorderRange.low, rootIndex - 1,inorder));
        root.right = constructTree(preorder, preorderRange,
                                    inorder, new OrderRange(rootIndex + 1, inorderRange.high, inorder));
        return root;
    }


    private int findInInorder(int[] tree, int value, int low, int high) {
        for (int i = low; i <= high; ++i) {
            if (tree[i] == value) {
                return i;
            }
        }
        return ERROR_CODE;
    }
}
