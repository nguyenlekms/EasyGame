package Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TwoSum {
    // Time: O(n), Space: O(n)
    public int[] twoSumUsingJavaStream(int[] nums, int target) {
        Map<Integer, Integer> foundSet = new HashMap<>();

        return IntStream.range(0, nums.length)
            .mapToObj(i -> new int[]{i, nums[i]})
            .filter(pair -> {
                int complement = target - pair[1];
                if (foundSet.containsKey(complement)) {
                    return true;
                }
                foundSet.put(pair[1], pair[0]);
                return false;
            })
            .map(pair -> new int[]{foundSet.get(target - pair[1]), pair[0]})
            .findFirst()
            .orElse(new int[]{});
    }

    // Time: O(n)
    public int[] twoSumHashTable(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;
        for (int idx = 0; idx < n; idx++) {
            numMap.put(nums[idx], idx);
        }

        // If a + b = c then the following is also true b = c - a
        for (int idx = 0; idx < n; idx++) {
            int complement = target - nums[idx];
            if (numMap.containsKey(complement) && numMap.get(complement) != idx ) {
                return new int[]{idx, numMap.get(complement)};
            }
        }
        return new int[]{}; // No solution found
    }

    // Time: O(N^2)
    public int[] twoSumBruteForce(int[] nums, int target){
        int n = nums.length;
        for (int i = 0; i < n - 1 ; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
