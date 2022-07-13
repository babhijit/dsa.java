package abhijit.learnitivity.dsa.leetcode.tree.binary.binary_tree_level_order_traversal_102;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCase {
    public final Integer[] root;
    public final int[][] output;

    public TestCase(Integer[] root, int[][] output) {
        this.root = root;
        this.output = output;
    }

    public List<List<Integer>> getExpected() {
        List<List<Integer>> expected = new ArrayList<>();
        for (var integers : output) {
            var intList = Arrays.stream(integers).boxed().toList();
            expected.add(intList);
        }
        return expected;
    }

}
