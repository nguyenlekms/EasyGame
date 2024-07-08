package Easy;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially.
 * The remaining elements of nums are not important as well as the size of nums. Return k.
 */
public class RemoveDuplicatesFromSortedArray {
    // Time: O(n), Space: O(1)
    public int removeDuplicatesTwoPointers(int[] nums) {
        if (nums.length == 0) return 0;

        int uniqueIndex = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[uniqueIndex] = nums[i];
                uniqueIndex++;
            }
        }

        return uniqueIndex;
    }

    // Time: O(n + m log m) - HashSet  O(n) + Sort  O(m log m), Space: O(n + m)
    public int removeDuplicatesBySet(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] uniqueNums = new int[set.size()];
        int index = 0;
        for (int num : set) {
            uniqueNums[index++] = num;
        }
        System.arraycopy(uniqueNums, 0, nums, 0, uniqueNums.length);

        return set.size();
    }

    public int removeDuplicatesBySetJavaStream(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        int[] uniqueNums = Arrays.stream(nums)
                .filter(e -> set.add(e))
                .toArray();
        System.arraycopy(uniqueNums, 0, nums, 0, uniqueNums.length);
        return set.size();
    }
}
