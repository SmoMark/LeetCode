package com.smomark;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class Topic20 {
    private static final Set<Character> leftSet = new HashSet<>();

    static {
        leftSet.add('(');
        leftSet.add('[');
        leftSet.add('{');
    }

    public boolean isValid(String s) {
        if (s == null || "".equals(s)) {
            return true;
        } else if (s.length() == 1) {
            return false;
        }

        Stack<Character> leftStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (leftSet.contains(c)) {
                leftStack.add(c);
            } else if (leftStack.isEmpty() || leftStack.pop() != getMatchChar(c)) {
                return false;
            }
        }
        return leftStack.isEmpty();
    }

    private char getMatchChar(char c) {
        switch (c) {
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
            default:
                throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Topic20().isValid("(("));
        System.out.println(new Topic20().isValid("()"));
        System.out.println(new Topic20().isValid("()[]{}"));
        System.out.println(new Topic20().isValid("(]"));
        System.out.println(new Topic20().isValid("([)]"));
        System.out.println(new Topic20().isValid("{[]}"));
    }
}
