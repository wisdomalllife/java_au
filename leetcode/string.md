# String

+ [Group Anagrams](#group-anagrams)
+ [Valid Palindrome](#valid-palindrome)
+ [Longest Palindromic Substring](#longest-palindromic-substring)
+ [Palindromic Substrings](#palindromic-substrings)

## Palindromic Substrings

https://leetcode.com/problems/palindromic-substrings/

```java
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
```

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
