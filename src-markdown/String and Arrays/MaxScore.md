# Max Score After Splitting a String

## Question

You are given a binary string `s` (a string consisting only of '0's and '1's). A `split` of an empty string is an empty string, and a `split` of s consists of two non-empty strings `a` and `b`, such that `a + b = s`.

The score of a `split` is the number of '0's in `a` plus the number of '1's in `b`.

Return the maximum score possible after splitting the string.

**Example:**

Input: `s = "011101"`

Output: `4`

Explanation: One way to split maximizes the score:

- `a = "0"` (score 1)
- `b = "11101"` (score 3)

Total score: 1 + 3 = 4.


## Hint

Prefix-sum


Challenge

Can we develop the code in O(1) TC?


## Time Complexity

The time complexity of the algorithm is O(n), where n is the length of the input string.



## LeetCode URL

[Max Score After Splitting a String - LeetCode](https://leetcode.com/problems/maximum-score-after-splitting-a-string/)

## Code

```java
public int maxScore(String s) {
    char[] chars = s.toCharArray();
    int[] left_prefix = new int[chars.length];
    left_prefix[0] = chars[0] == '0' ? 1 : 0;
    int[] right_prefix = new int[chars.length];
    right_prefix[chars.length - 1] = chars[chars.length - 1] == '1' ? 1 : 0;
    int maxScore = 0;

    for (int j = 1; j < chars.length - 1; j++) {
        left_prefix[j] = chars[j] == '0' ? left_prefix[j - 1] + 1 : left_prefix[j - 1];
        right_prefix[chars.length - 1 - j] = chars[chars.length - 1 - j] == '1'
                ? right_prefix[chars.length - 1 - j + 1] + 1
                : right_prefix[chars.length - 1 - j + 1];
    }

    for (int j = 0; j < chars.length - 1; j++) {
        maxScore = Math.max(maxScore, (left_prefix[j] + right_prefix[j + 1]));
    }
    return maxScore;
}
```
