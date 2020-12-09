# String

+ [Group Anagrams](#group-anagrams)

## Group Anagrams

https://leetcode.com/problems/group-anagrams/submissions/

```java
class Solution {
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
}
```
