package abhijit.learnitivity.dsa.leetcode.tree.binary.binary_tree_level_order_traversal_102;

import abhijit.learnitivity.dsa.leetcode.AbstractExecuteTests;
import abhijit.learnitivity.dsa.tree.binary.BinaryTree;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeLevelOrderTraversalTest extends AbstractExecuteTests<TestCase> {
    public BinaryTreeLevelOrderTraversalTest() {
        super("BinaryTreeLevelOrderTraversalTests.json", TestCase.class);
    }

    @Override
    protected void executeTest(TestCase tc) {
        executeTest(tc.root, tc.getExpected());
    }

    private void executeTest(Integer[] tree, List<List<Integer>> expected) {
        var solution = new BinaryTreeLevelOrderTraversal();
        var binaryTree = new BinaryTree(tree, true);
        List<List<Integer>> actual = solution.levelOrder(binaryTree.root);
        assertEquals(expected, actual);
    }
}