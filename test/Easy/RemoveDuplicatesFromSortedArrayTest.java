package Easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesFromSortedArrayTest {
    private static final Logger LOGGER = Logger.getLogger(RemoveDuplicatesFromSortedArrayTest.class.getName());

    @BeforeEach
    void setUp() {
        Handler consoleHandler = new ConsoleHandler();

        consoleHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                String message = record.getMessage();
                return "\u001B[32m" + message + "\u001B[0m" + System.lineSeparator();
            }
        });
        LOGGER.setUseParentHandlers(false);
        LOGGER.addHandler(consoleHandler);
    }

    @Test
    void removeDuplicatesTwoPointers() {
        RemoveDuplicatesFromSortedArray removeDuplicates = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1, 1, 2};
        int[] expectedOutput = {1, 2};
        int k = removeDuplicates.removeDuplicatesTwoPointers(nums);
        assertEquals(expectedOutput.length, k);
        for (int i = 0; i < k; i++) {
            assertEquals(expectedOutput[i], nums[i]);
        }
    }

    @Test
    void testRemoveDuplicatesTwoPointersEdgeCase() {
        RemoveDuplicatesFromSortedArray removeDuplicates = new RemoveDuplicatesFromSortedArray();
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] expectedOutput2 = {0, 1, 2, 3, 4};
        int k2 = removeDuplicates.removeDuplicatesTwoPointers(nums2);
        assertEquals(expectedOutput2.length, k2);
        for (int i = 0; i < k2; i++) {
            assertEquals(expectedOutput2[i], nums2[i]);
        }
    }

    @Test
    void testRemoveDuplicatesTwoPointersEmptyArray() {
        RemoveDuplicatesFromSortedArray removeDuplicates = new RemoveDuplicatesFromSortedArray();
        int[] nums3 = {};
        int[] expectedOutput3 = {};
        int k3 = removeDuplicates.removeDuplicatesTwoPointers(nums3);
        assertEquals(expectedOutput3.length, k3);
        assertArrayEquals(expectedOutput3, nums3);
    }

    @Test
    void removeDuplicatesBySet() {
        RemoveDuplicatesFromSortedArray removeDuplicates = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1, 1, 2};
        int[] expectedOutput = {1, 2};
        int k = removeDuplicates.removeDuplicatesBySet(nums);
        assertEquals(expectedOutput.length, k);
        for (int i = 0; i < k; i++) {
            assertEquals(expectedOutput[i], nums[i]);
        }
    }

    @Test
    void removeDuplicatesBySetJavaStream() {
        RemoveDuplicatesFromSortedArray removeDuplicates = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1, 1, 2};
        int[] expectedOutput = {1, 2};
        int k = removeDuplicates.removeDuplicatesBySetJavaStream(nums);
        assertEquals(expectedOutput.length, k);
        for (int i = 0; i < k; i++) {
            assertEquals(expectedOutput[i], nums[i]);
        }
    }
}