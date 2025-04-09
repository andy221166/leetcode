package org.andy.leetcode;

public class MergeStringsAlternately {

  public static class Solution {

    public String mergeAlternately(String word1, String word2) {
      int minLength = Math.min(word1.length(), word2.length());
      StringBuilder result = new StringBuilder();
      for (int i = 0; i < minLength; i++) {
        result.append(word1.charAt(i));
        result.append(word2.charAt(i));
      }

      if (word1.length() == word2.length()) {
        return result.toString();
      }

      if (word2.length() == minLength) {
        result.append(word1.substring(minLength));
      } else {
        result.append(word2.substring(minLength));
      }

      return result.toString();
    }
  }
}
