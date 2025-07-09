// 📝 Problem Statement
// You are given a string s consisting only of lowercase English letters.
// Your task is to count how many substrings of length 3 contain exactly 2 vowels.
// ✅ Input
// A single string s of length n (1 ≤ n ≤ 10⁵)
// ✅ Output
// Print a single integer — the count of substrings of length 3 that contain exactly 2 vowels.


import java.util.*;

public class Main {
    static boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int count = 0;
        for (int i = 0; i <= s.length() - 3; i++) {
            int vowelCount = 0;
            for (int j = i; j < i + 3; j++) {
                if (isVowel(s.charAt(j))) vowelCount++;
            }
            if (vowelCount == 2) count++;
        }

        System.out.println(count);
    }
}

