

+ [Palindromic Substrings](#palindromic-substrings)

## Palindromic Substrings

https://leetcode.com/problems/palindromic-substrings/

```java
class Solution {
    public int countSubstrings(String s) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            counter += growAroundCenter(s, i, i);
            counter += growAroundCenter(s, i, i + 1);
        }
        return counter;
    }
    private int growAroundCenter(String s, int left, int right) {
        int counter = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            counter++;
        }
        return counter;
    }
}
```