package org.andy.leetcode;

import org.andy.leetcode.MergeSortedArray.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeSortedArrayTests {

  @Test
  public void testMergeSortedArray1() {
    int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
    int m = 3;
    int[] nums2 = new int[]{2, 5, 6};
    int n = 3;

    Solution solution1 = new Solution();
    solution1.merge(nums1, m, nums2, n);

    int[] expected = new int[]{1, 2, 2, 3, 5, 6};
    Assertions.assertArrayEquals(expected, nums1);
  }

  @Test
  public void testMergeSortedArray2() {
    int[] nums1 = new int[]{1};
    int m = 1;
    int[] nums2 = new int[]{};
    int n = 0;

    Solution solution1 = new Solution();
    solution1.merge(nums1, m, nums2, n);

    int[] expected = new int[]{1};
    Assertions.assertArrayEquals(expected, nums1);
  }

  @Test
  public void testMergeSortedArray3() {
    int[] nums1 = new int[]{0};
    int m = 0;
    int[] nums2 = new int[]{1};
    int n = 1;

    Solution solution1 = new Solution();
    solution1.merge(nums1, m, nums2, n);

    int[] expected = new int[]{1};
    Assertions.assertArrayEquals(expected, nums1);
  }
}
