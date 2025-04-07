# Merge Sorted Array

## Approach 1: Merge and sort

**Intuition**

A naive approach would be to simply write the values from `nums2` into the end of `nums1`, and then sort `nums1`. Remember that we do not need to return a value, as we should modify `nums1` in-place. While straightforward to code, this approach has a high time complexity as we're not taking advantage of the existing sorting.

**Implementation**

```java
import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
```

**Complexity Analysis**

* Time complexity: O((n+m)log(n+m))

The cost of sorting a list of length x using a built-in sorting algorithm is O(xlogx). Because in this case, we're sorting a list of length m+n, we get a total time complexity of O((n+m)log(n+m)).

* Space complexity: O(n), but it can vary

Most programming languages have a built-in sorting algorithm that uses O(n) space.

---

## Approach 2: Three Pointers (Start From the Beginning)

**Intuition**

Because each array is already sorted, we can achieve an O(n+m) time complexity with the help of the two-pointer technique.

**Algorithm**

The simplest implementation would be to make a copy of the values in `nums1`, called `nums1Copy`, and then use two read pointers and one write pointer to read values from `nums1Copy` and `nums2` and write them into `nums1`.
- Initialize `nums1Copy` to a new array containing the first `m` values of `nums1`.
- Initialize the read pointer `p1` to the beginning of `nums1Copy`.
- Initialize the read pointer `p2` to the beginning of `nums2`.
- Initialize the write pointer `p` to the beginning of `nums1`.
- While `p` is still within `nums1`:
  - If `nums1Copy[p1]` exists and is less than or equal to `nums2[p2]`:
    - Write `nums1Copy[p1]` into `nums1[p]`, and increment `p1` by 1.
  - Else
    - Write `nums2[p2]` into `nums1[p]`, and increment `p2` by 1.
  - Increment `p` by 1.

**Implementation**

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of the first m elements of nums1.
        int[] nums1Copy = new int[m];
        for (int i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        }

        // Read pointers for nums1Copy and nums2 respectively.
        int p1 = 0;
        int p2 = 0;

        // Compare elements from nums1Copy and nums2 and write the smallest to nums1.
        for (int p = 0; p < m + n; p++) {
            // We also need to ensure that p1 and p2 aren't over the boundaries
            // of their respective arrays.
            if (p2 >= n || (p1 < m && nums1Copy[p1] < nums2[p2])) {
                nums1[p] = nums1Copy[p1++];
            } else {
                nums1[p] = nums2[p2++];
            }
        }
    }
}
```

**Complexity Analysis**

* Time complexity: O(n+m)

We are performing n+2⋅m reads and n+2⋅m writes. Because constants are ignored in Big O notation, this gives us a time complexity of O(n+m).

* Space complexity: O(m)

We are allocating an additional array of length m.

---

## Approach 3: Three Pointers (Start From the End)

**Intuition**

Approach 2 already demonstrates the best possible time complexity, O(n+m), but still uses additional space. This is because the elements of array `nums1` have to be stored somewhere so that they aren't overwritten.

So, what if instead we start to overwrite `nums1` from the end, where there is no information yet?

The algorithm is similar to before, except this time we set `p1` to point at index `m - 1` of `nums1`, `p2` to point at index `n - 1` of nums2, and p to point at index `m + n - 1` of nums1. This way, it is guaranteed that once we start overwriting the first `m` values in `nums1`, we will have already written each into its new position. In this way, we can eliminate the additional space.

**Implementation**

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Set p1 and p2 to point to the end of their respective arrays.
        int p1 = m - 1;
        int p2 = n - 1;

        // And move p backward through the array, each time writing
        // the largest value pointed at by p1 or p2.
        for (int p = m + n - 1; p >= 0; p--) {
            if (p2 < 0) {
                break;
            }
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1--];
            } else {
                nums1[p] = nums2[p2--];
            }
        }
    }
}
```

**Complexity Analysis**

* Time complexity: O(n+m)

Same as Approach 2.

* Space complexity: O(1)

Unlike Approach 2, we're not using an extra array.
