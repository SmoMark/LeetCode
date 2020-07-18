package com.smomark;

/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Topic07 {
    public int reverse(int x) {
        int reverseResult = 0;
        int lastNum;
        while (x != 0) {
            lastNum = x % 10;
            if(reverseResult > Integer.MAX_VALUE / 10 || (reverseResult == Integer.MAX_VALUE / 10 && lastNum > Integer.MAX_VALUE % 10)){
                return 0;
            } else if (reverseResult < Integer.MIN_VALUE / 10 || (reverseResult == Integer.MIN_VALUE / 10 && lastNum < Integer.MIN_VALUE % 10)){
                return 0;
            }
            x /= 10;
            reverseResult = (reverseResult * 10) + lastNum;
        }
        return reverseResult;
    }

    public static void main(String[] args) {
        System.out.println(new Topic07().reverse(123));
        System.out.println(new Topic07().reverse(-123));
        System.out.println(new Topic07().reverse(120));
        System.out.println(new Topic07().reverse(1534236469));
        System.out.println(new Topic07().reverse(-2147483648));
    }
}
