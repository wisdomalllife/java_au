# String

1. https://leetcode.com/problems/group-anagrams/
2. https://leetcode.com/problems/valid-palindrome/
3. https://leetcode.com/problems/longest-palindromic-substring/
4. https://leetcode.com/problems/palindromic-substrings/

+ [Group Anagrams](#group-anagrams)
+ [Valid Palindrome](#valid-palindrome)

## Valid Palindrome

https://leetcode.com/problems/valid-palindrome/

```java
private static boolean isAlphaNumeric(char c) {  //psvm+tab
    return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
}// static показывает, что он не принадлежит объекту, а классу(это метод)
private static char toLowerCase(char c) {
    return c >= 'A' && c <= 'Z' ? (char) (c + ('a' - 'A')) : c;
    //? как if.... ,: иначе/ привели к нижнему регистру
    // вопрос? действие : иначе действие
}
public boolean isPalindrome(String s) {
    if (s == null || s.isEmpty() || s.length() == 1) {
        return true;
    }
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
        if (!isAlphaNumeric(s.charAt(left))) {// ! отрицание
            left++;
        } else if (!isAlphaNumeric(s.charAt(right))) {
            right--;
        } else if (toLowerCase(s.charAt(left)) != toLowerCase(s.charAt(right))) {
            return false;
        } else {
            left++;
            right--;
        }
    }
    return true;
}
```

## Group Anagrams

https://leetcode.com/problems/group-anagrams/submissions/

```java
public List<List<String>> groupAnagrams(String[] strs) {
    if (strs.length == 0) return new ArrayList();
    Map<String, List> answer = new HashMap<String, List>();
    for (String s : strs) {
        char[] word = s.toCharArray(); // перевод в массив char
        Arrays.sort(word);
        String key = String.valueOf(word); // преобразует в нужный тип данных
        if (!answer.containsKey(key)) answer.put(key, new ArrayList());
        answer.get(key).add(s);
    }
    return new ArrayList(answer.values());
}
```
