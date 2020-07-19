package com.smomark;

/**
 * 28. 实现 strStr()
 * 难度
 * 简单
 *
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class Topic28 {

    public int strStr(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        }
        if (needle == null || needle.equals("")) {
            return 0;
        }
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        int j = 0, i = 0;
        for (; i < haystackLength;) {
            if (j >= needleLength) {
                break;
            }
            if (haystackArray[i] == needleArray[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j >= needleLength) {
            return i - j;
        }
        return -1;
    }


    /**
     * Sunday算法
     * @param haystack 文本串
     * @param needle 逮匹配字串
     * @return 首次出现文职
     */
    public int strStr2(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        }
        if (needle == null || needle.equals("")) {
            return 0;
        }
        int i = 0, j = 0, p = i + needle.length();
        int it = i;
        while (true) {
            if (j == needle.length()) {
                return i - j;
            }
            if (haystack.length() > i && haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (haystack.length() > p) {
                if (needle.indexOf(haystack.charAt(p)) != -1) {
                    i = it + (needle.length() - needle.lastIndexOf(haystack.charAt(p)));
                    j = 0;
                } else {
                    i = p + 1;
                    j = 0;
                }
                it = i;
                p = i + needle.length();
            } else {
                break;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Topic28().strStr2("mississippi", "pi"));
        System.out.println(new Topic28().strStr2("mississippi", "issip"));
        System.out.println(new Topic28().strStr2("", "a"));
        System.out.println(new Topic28().strStr2("aaa", "aaa"));
        System.out.println(new Topic28().strStr2("aaa", "a"));
        System.out.println(new Topic28().strStr2("a", ""));
        System.out.println(new Topic28().strStr2("", ""));
        System.out.println(new Topic28().strStr2("hello", "ll"));
        System.out.println(new Topic28().strStr2("aaaaa", "bba"));
    }
}
