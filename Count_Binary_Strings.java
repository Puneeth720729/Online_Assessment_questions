// Problem: Count Binary Strings with Exactly One "00"
// Given a number of test cases T. For each test case, you're given an integer n.
// Your task is to determine how many binary strings of length n contain **exactly one occurrence** of the substring "00" (two consecutive zeroes).
// ❗ Conditions:
// - Only binary strings (composed of '0' and '1') of length n are considered.
// - The string must contain **exactly one** non-overlapping occurrence of "00".
// - Strings with more than one "00" (even overlapping ones, like "000") are invalid.
// Input:
// - First line: T (number of test cases)
// - Next T lines: Each line contains one integer n
// Output:
// - For each test case, output the count of valid binary strings of length n that satisfy the condition.
// Constraints:
// - 1 ≤ T ≤ 100
// - 1 ≤ n ≤ 20
// Example:
// Input:
// 2
// 2
// 3
// Output:
// 1
// 2
// Explanation:
// For n = 2 → valid string is: 00
// For n = 3 → valid strings are: 001, 100



import java.util.*;

public class Main {

    static String convertToBinary(int num, int length) {
        String binary = Integer.toBinaryString(num);
        while (binary.length() < length) {
            binary = '0' + binary;
        }
        return binary;
    }

    static boolean hasExactlyOneDoubleZero(int num, int length) {
        String binary = convertToBinary(num, length);
        int count = 0;
        for (int i = 0; i < binary.length() - 1; i++) {
            if (binary.charAt(i) == '0' && binary.charAt(i + 1) == '0') {
                count++;
            }
        }
        return count == 1;
    }

    static int countValidBinaryStrings(int n) {
        int total = (int) Math.pow(2, n);
        int validCount = 0;
        for (int i = 0; i < total; i++) {
            if (hasExactlyOneDoubleZero(i, n)) {
                validCount++;
            }
        }
        return validCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int n = sc.nextInt();
            System.out.println(countValidBinaryStrings(n));
        }
    }
}
