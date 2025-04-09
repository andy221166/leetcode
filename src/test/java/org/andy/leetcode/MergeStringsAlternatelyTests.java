package org.andy.leetcode;

import org.andy.leetcode.MergeStringsAlternately.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeStringsAlternatelyTests {

  @Test
  public void testCase1() {
    String word1 = "abc";
    String word2 = "pqr";

    Solution solution = new Solution();
    String actual = solution.mergeAlternately(word1, word2);

    String expected = "apbqcr";
    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void testCase2() {
    String word1 = "ab";
    String word2 = "pqrs";

    Solution solution = new Solution();
    String actual = solution.mergeAlternately(word1, word2);

    String expected = "apbqrs";
    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void testCase3() {
    String word1 = "abcd";
    String word2 = "pq";

    Solution solution = new Solution();
    String actual = solution.mergeAlternately(word1, word2);

    String expected = "apbqcd";
    Assertions.assertEquals(expected, actual);
  }
}
