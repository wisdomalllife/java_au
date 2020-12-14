

+ [Longest Palindromic Substring](#longest-palindromic-substring)

## Longest Palindromic Substring

https://leetcode.com/problems/longest-palindromic-substring/

```java
public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = growAroundCenter(s, i, i);
        int len2 = growAroundCenter(s, i, i + 1);//для палиндрома из четного кол. элементов
        int len = Math.max(len1, len2);
        if (len > end - start + 1) { // i - центр нового подпалиндрома
            start = i - (len - 1) / 2;// len-1 для четного случая
            end = i + len / 2;//
        }
    }
    return s.substring(start, end + 1); // вывод  подстроки, substring берет до end не включительно -> +1
}
private int growAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
    }
    return right - left - 1;// смотрим сколько одинаковых пар по бокам и определяем длину подпалиндрома (r=a+1, l=b-1, r-l-1=a-b+1+1-1=a-b+1=len)
}
```
