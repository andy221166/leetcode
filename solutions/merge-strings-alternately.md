# Merge Strings Alternately

## Overview

We are given two strings `word1` and `word2`.

Our task is to merge the strings by adding letters in alternating order, starting with `word1`. If one string is longer than the other, the additional letters must be appended to the end of the merged string.

We must return the merged string that has been formed.

---

## Approach 1: Two Pointers

### Intuition

There are numerous ways in which we can combine the given strings. We've covered a few of them in this article.

An intuitive method is to use two pointers to iterate over both strings. Assume we have two pointers, `i` and `j`, with `i` pointing to the first letter of `word1` and `j` pointing to the first letter of `word2`. We also create an empty string result to store the outcome.

We append the letter pointed to by pointer `i` i.e., `word1[i]`, and increment `i` by 1 to point to the next letter of word1. Because we need to add the letters in alternating order, next we append `word2[j]` to result. We also increase `j` by 1.

We continue iterating over the given strings until both are exhausted. We stop appending letters from `word1` when `i` reaches the end of `word1`, and we stop appending letters from `word2`' when `j` reaches the end of `word2`.

### Algorithm

- Create two variables, `m` and `n`, to store the length of `word1` and `word2`.
- Create an empty string variable result to store the result of merged words.
- Create two pointers, `i` and `j` to point to indices of `word1` and `word2`. We initialize both of them to 0.
- While `i < m || j < n`:
  - If `i < m`, it means that we have not completely traversed `word1`. As a result, we append `word1[i]` to result. We increment `i` to point to next index of `word1`.
  - If `j < n`, it means that we have not completely traversed `word2`. As a result, we append `word2[j]` to result. We increment `j` to point to next index of `word2`.
- Return result.

It is important to note how we form the result string in the following codes:
- cpp: The strings are mutable in cpp, which means they can be changed. As a result, we used the string variable and performed all operations on it. It takes constant time to append a character to the string.
- java: The String class is immutable in java. So we used the mutable StringBuilder to concatenate letters to result.
- python: Strings are immutable in python as well. As a result, we used the list result to append letters and later joined the list with an empty string to return it as a string object. The join operation takes linear time equal to the length of result to merge result with empty string.

### Implementation

```java
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;

        while (i < m || j < n) {
            if (i < m) {
                result.append(word1.charAt(i++));
            }
            if (j < n) {
                result.append(word2.charAt(j++));
            }
        }

        return result.toString();
    }
}
```

### Complexity Analysis

Here, `m` is the length of `word1` and `n` is the length of `word2`.

* Time complexity: O(m+n)

We iterate over word1 and word2 once and push their letters into result. It would take O(m+n) time.

* Space complexity: O(1) or O(m+n)

Without considering the space consumed by the input strings (`word1` and `word2`) and the output string (`result`), we do not use more than constant space.
In Java, the StringBuilder requires O(n+m) space to store the merged result. Thus, while auxiliary space is O(1), total space complexity is O(n+m).

---

## Approach 2: One Pointer

### Intuition

To merge the given words, we can also use a single pointer.

Let `i` be the pointer that we'll use. We begin with `i = 0` and progress to the size of the longer word between `word1` and `word2`, i.e., till `i = max(word1.length(), word2.length())`.

As we progress to the size of a longer word, we check each time if `i` points to an index that is in bounds of the words or not. If `i < word1.length()`, we append `word1[i]` to result. Similarly, if `i < word2.length()`, we append `word2[i]` to results.

However, if `i` exceeds the length of any word, we don't have any letters to add from that word, so we ignore it and continue adding the letter from the longer word.

### Algorithm

- Create two variables, `m` and `n`, to store the length of `word1` and `word2`.
- Create an empty string variable result to store the result of merged words.
- Iterate over `word1` and `word2` using a loop running from `i = 0` to `i < max(m, n)` and keep incrementing `i` by 1 after each iteration:
  - If `i < m`, it means that we have not completely traversed `word1`. As a result, we append `word1[i]` to result.
  - If `i < n`, it means that we have not completely traversed `word2`. As a result, we append `word2[i]` to result.
- Return result.

### Implementation

```java
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < Math.max(m, n); i++) {
            if (i < m) {
                result.append(word1.charAt(i));
            }
            if (i < n) {
                result.append(word2.charAt(i));
            }
        }

        return result.toString();
    }
}
```

### Complexity Analysis

Here, `m` is the length of `word1` and `n` is the length of `word2`.

* Time complexity: O(m+n)

We iterate over word1 and word2 once pushing their letters into result. It would take O(m+n) time.

* Space complexity: O(1)

Without considering the space consumed by the input strings (word1 and word2) and the output string (result), we do not use more than constant space.
