package com.smomark;

/**
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class Topic09 {
    /*public boolean isPalindrome(int x) {
        String xStr = String.valueOf(x);
        int xStrLength = xStr.length();
        int middleIndex = xStrLength / 2;
        for (int i = 0; i < middleIndex; i++) {
            if (!Objects.equals(xStr.charAt(i), xStr.charAt(xStrLength - i - 1))) {
                return false;
            }
        }
        return true;
    }*/

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x > 0 && x < 10) {
            return true;
        }
        int div = 1;
        while (x / div > 9) {
            div *= 10;
        }
        int left, right;
        while (x > 0) {
            right = x % 10;
            left = x / div;
            if (left != right) {
                return false;
            }
            x = x % div / 10;
            div /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Topic09().isPalindrome(121));
        System.out.println(new Topic09().isPalindrome(-121));
        System.out.println(new Topic09().isPalindrome(10));
        System.out.println(new Topic09().isPalindrome(313));
        System.out.println(new Topic09().isPalindrome(1001));
    }
}
