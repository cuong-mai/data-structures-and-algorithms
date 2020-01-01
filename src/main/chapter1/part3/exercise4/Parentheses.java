package chapter1.part3.exercise4;

import chapter1.part3.MyStack;

public class Parentheses {

    public static boolean balanced(String s) {
        MyStack<Character> stack = new MyStack<>();
        
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Character top = stack.peek();
            if (top == null || !top.equals(getOpen(c))) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty();
        
    }

    private static Character getOpen(char close) {
        switch (close) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
        }
        return null;
    }
}
