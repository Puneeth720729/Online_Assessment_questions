/*
Problem: Most Frequent Digital Root

Description:
You are given an array of integers. For each number, convert it to a single-digit number
by repeatedly summing its digits. After conversion, return the number that appears most
frequently. If there's a tie, return the maximum number among them.

Input:
- An integer n (number of elements)
- Followed by n space-separated integers

Output:
- The most frequent single-digit number (or the maximum one in case of tie)

Example:
Input:
5
99 56 73 12 18

Output:
9
*/


import java.util.*;

public class Main {
    static int convert(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        if (sum > 9) return convert(sum);
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = convert(sc.nextInt());
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int maxFreq = 0;
        int result = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (freq > maxFreq || (freq == maxFreq && num > result)) {
                maxFreq = freq;
                result = num;
            }
        }

        System.out.println(result);
    }
}
