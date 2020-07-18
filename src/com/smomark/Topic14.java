package com.smomark;

import java.util.Objects;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */
public class Topic14 {
    public String longestCommonPrefix(String[] strs) {
        if (Objects.isNull(strs) || strs.length == 0) {
            return "";
        }
        String firstStr = strs[0];
        if (strs.length == 1) {
            return firstStr;
        }
        int i, j;
        for (i = 0; i < firstStr.length(); i++) {
            for (j = 1; j < strs.length; j++) {
                String str = strs[j];
                if (str.length() <= i || str.charAt(i) != firstStr.charAt(i)) {
                    break;
                }
            }
            if (j < strs.length) {
                break;
            }
        }
        if (i == 0) {
            return "";
        }
        return firstStr.substring(0, i);
    }

    public static void main(String[] args) {
        System.out.println(new Topic14().longestCommonPrefix(new String[]{"aa", "a"}));
        System.out.println(new Topic14().longestCommonPrefix(null));
        System.out.println(new Topic14().longestCommonPrefix(new String[]{"flower"}));
        System.out.println(new Topic14().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(new Topic14().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
