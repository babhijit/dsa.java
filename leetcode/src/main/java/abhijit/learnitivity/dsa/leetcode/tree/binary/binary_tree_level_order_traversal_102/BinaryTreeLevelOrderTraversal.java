package abhijit.learnitivity.dsa.leetcode.tree.binary.binary_tree_level_order_traversal_102;

import abhijit.learnitivity.dsa.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();

        if (isNull(root)) {
            return levelOrder;
        }

        List<TreeNode> currentLevel = new LinkedList<>();
        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            addLevelValuesToLevelOrder(currentLevel, levelOrder);
            List<TreeNode> nextLevel = new ArrayList<>();
            for (TreeNode node : currentLevel) {
                addToNextLevel(nextLevel, node.left, node.right);
            }
            currentLevel = nextLevel;
        }

        return levelOrder;
    }

    private void addToNextLevel(List<TreeNode> nextLevel, TreeNode left, TreeNode right) {
        addToNextLevel(nextLevel, left);
        addToNextLevel(nextLevel, right);
    }

    private void addToNextLevel(List<TreeNode> nextLevel, TreeNode node) {
        if (nonNull(node)) {
            nextLevel.add(node);
        }
    }

    private void addLevelValuesToLevelOrder(List<TreeNode> level, List<List<Integer>> levelOrder) {
        ArrayList<Integer> currentLevel = new ArrayList<>();

        level.forEach(treeNode -> currentLevel.add(treeNode.val));

        levelOrder.add(currentLevel);
    }
}
