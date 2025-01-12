# Valid Palindrome

## Problem Statement

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

```agsl
Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
```

## Code

```java
public class PalindromePermutation {

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int leftPtr = 0;
        int rightPtr = chars.length - 1;
        while (leftPtr < rightPtr) {
            while (leftPtr < rightPtr && !Character.isLetterOrDigit(chars[leftPtr]))
                leftPtr++;
            while (leftPtr < rightPtr && !Character.isLetterOrDigit(chars[rightPtr]))
                rightPtr--;

            if (chars[leftPtr] != chars[rightPtr]) return false;
            leftPtr++;
            rightPtr--;
        }

        return true;
    }

}
```

## Time Complexity
The time complexity of the solution is O(n), where n is the length of the string. The algorithm traverses the string from both ends, and each character is checked once.