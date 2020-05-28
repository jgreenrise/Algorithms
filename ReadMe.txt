Things to implement

1. Cloning
http://www.jusfortechies.com/java/core-java/cloning.php

2. http://www.geeksforgeeks.org/find-distance-two-given-nodes/

public String longestPalindrome(String s) {

		if (s == null || s.length() < 1)
			return "";

		int start = 0, end = 0;

		for (int i = 0; i < s.length(); i++) {

			int len1 = expandAroundCenter(s, i, i); 			// "racecar"
			int len2 = expandAroundCenter(s, i, i + 1); 	// "aabbaa"
			int len = Math.max(len1, len2);

			if (len > end - start) {
				// Found palindrome
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}
