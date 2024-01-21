Given a character array `chars`, compress it using the following algorithm:

Begin with an empty string `s`. For each group of consecutive repeating characters in `chars`:

- If the group's length is greater than 1, append the character and the count to `s`.
- If the group's length is 1, append the character to `s`.

Modify the input array in-place to represent the compressed string.

Return the length of the compressed string.

### Time Complexity

The time complexity of this solution is O(n), where n is the length of the input array `chars`.

### Challenges

- The in-place modification of the array might be error-prone.
- Handling cases where the counter is greater than 9 and converting it to characters.
- Ensuring that the modified array contains the correct compressed string.

### Solution

```java
public static int compress(char[] chars) {

        if (chars.length == 1)
            return 1;

        char ch = chars[0];
        int counter = 1;
        int endRange = 1;
        for (int j = 1; j < chars.length; j++) {
            if (chars[j] == ch) {
                counter++;
            } else {
                if (counter > 9) {
                    String str = String.valueOf(counter);
                    char[] nums = str.toCharArray();
                    for (int num = 0; num < nums.length; num++) {
                        chars[endRange++] = nums[num];
                    }
                } else if (counter > 1) {
                    chars[endRange] = (char) (counter + '0');
                    endRange++;
                }
                ch = chars[j];
                counter = 1;
                chars[endRange] = ch;
                endRange++;
            }
        }

        if (counter > 9) {
            String str = String.valueOf(counter);
            char[] nums = str.toCharArray();
            for (int num = 0; num < nums.length; num++) {
                chars[endRange++] = nums[num];
            }
        } else if (counter > 1) {
            chars[endRange] = (char) (counter + '0');
            endRange++;
        }

        return endRange;

    }
```


This solution iterates through the array, counts consecutive repeating characters, and modifies the array in-place to represent the compressed string. The `handleGroup` method is used to handle each group of characters based on the specified algorithm.
