package Easy;

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
}
