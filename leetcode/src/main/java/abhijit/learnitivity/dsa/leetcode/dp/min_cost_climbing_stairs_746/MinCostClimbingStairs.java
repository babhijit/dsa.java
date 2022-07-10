package abhijit.learnitivity.dsa.leetcode.dp.min_cost_climbing_stairs_746;

import static java.util.Objects.nonNull;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        assert nonNull(cost) && cost.length > 1: "cost must have at least 2 values";

        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        final int N = cost.length;
        int[] dp = new int[N + 1];
        for (int i = 2; i <= N; ++i) {
            int jumpOneStep = dp[i - 1] + cost[i - 1];
            int jumpTwoSteps = dp[i - 2] + cost[i - 2];
            dp[i] = Math.min(jumpOneStep, jumpTwoSteps);
        }

        return dp[N];
    }
}
