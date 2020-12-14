# Array

+ [Squares of a Sorted Array](#squares-of-a-sorted-array)

## Squares of a Sorted Array
https://leetcode.com/problems/squares-of-a-sorted-array/
```java
public int findFirstPositive(int[] A) {
    for (int i = 0; i < A.length; i++) {
        if (A[i] >= 0) {
            return i;
        }
    }
    return A.length;
}

public int[] sortedSquares(int[] A) {
    if (A == null) return A;
    int elem = findFirstPositive(A);
    int left = elem - 1;
    int right = elem;
    int[] result = new int[A.length];
    int count = 0;
    while (left >= 0 && right < A.length) {
        if (A[left] * A[left] < A[right] * A[right]) {
            result[count++] = A[left] * A[left];
            left--;
        } else {
            result[count++] = A[right] * A[right];
            right++;
        }
    }
    while (left >= 0) {
        result[count++] = A[left] * A[left];
        left--;
    }
    while (right < A.length) {
        result[count++] = A[right] * A[right];
        right++;
    }
    return result;
}

```