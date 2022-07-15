package abhijit.learnitivity.dsa.leetcode.tree.binary.tree_from_pre_in_order_105;

import abhijit.learnitivity.dsa.leetcode.AbstractExecuteTests;
import abhijit.learnitivity.dsa.leetcode.tree.binary.tree_from_pre_in_order_105.tree_from_pre_in_order_105.TreeFromPreInorderTraversals;
import abhijit.learnitivity.dsa.tree.binary.BinaryTree;
import abhijit.learnitivity.dsa.tree.binary.TreeNode;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TreeFromPreInorderTraversalsTest extends AbstractExecuteTests<TestCase> {

    public TreeFromPreInorderTraversalsTest() {
        super("TreeFromPreInorderTraversalsTests.json", TestCase.class);
    }

    @Override
    protected void executeTest(TestCase tc) {
        executeTest(tc.input, tc.output);
    }

    private void executeTest(TestCaseInput input, Integer[] expected) {
        var binaryTree = new BinaryTree(expected, true);
        executeTest(input, binaryTree.root);
    }

    private void executeTest(TestCaseInput input, TreeNode expected) {
        var solution = new TreeFromPreInorderTraversals();
        var actual = solution.buildTree(input.preorder, input.inorder);
        assertTrue(BinaryTree.equals(expected, actual));
    }
}