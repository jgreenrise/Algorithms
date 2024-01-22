# Determine if a String has All Unique Characters

## Problem Statement

Implement an algorithm to determine if a string has all unique characters. You can assume that the string contains only lowercase and uppercase letters.

## Approaches

### Approach 1: Using Set

```java
private static boolean isUnique_Set(String str) {
    if (str == null || str.length() < 2)
        return true;
    Set<Character> set = new HashSet<>();
    char[] chars = str.toCharArray();
    for (char ch : chars) {
        if (!set.isEmpty() && set.contains(ch))
            return false;
        set.add(ch);
    }
    return true;
}
```

**Time Complexity:** O(n), where n is the length of the string.

**Space Complexity:** O(min(n, 26)), considering only lowercase and uppercase letters.

### Approach 2: Sorting

```java
private static boolean isUnique(String str) {
    if (str == null || str.length() < 2)
        return true;
    char[] chars = str.toCharArray();
    Arrays.sort(chars);
    for (int j = 1; j < chars.length; j++) {
        if (chars[j] == chars[j - 1])
            return false;
    }
    return true;
}
```

**Time Complexity:** O(n log n), where n is the length of the string.

**Space Complexity:** O(1) - No additional space used.

### Approach 3: Using ASCII Array

```java
private static boolean isUnique_ascii(String str) {
    if (str == null || str.length() < 2)
        return true;
    int[] ascii = new int[26];

    for (int j = 0; j < str.length(); j++) {
        if (ascii[str.charAt(j) - 'a'] > 0)
            return false;
        ascii[str.charAt(j) - 'a']++;
    }
    return true;
}
```

**Time Complexity:** O(n), where n is the length of the string.

**Space Complexity:** O(1) - Fixed-size array of 26.

## Testing

```java
public static void main(String[] args) {
    String[] strs = {"", "aeppl", "apl", "abcdefghijklmnopqrstuvwxyza"};
    for (String str : strs) {
        System.out.println("1. Input Str: " + str + ", Output: " + isUnique_Set(str) + ", " + isUnique(str) + ", " + isUnique_ascii(str));
    }
}
```

## Limitations

- The provided solutions assume that the input string contains only lowercase and uppercase letters.

---
