package chapter1.part3.exercise9;

import chapter1.part3.MyStack;

public class NoLeftParenthesesToInfix {

    public static String convert(String input) {

        MyStack<String> output = new MyStack<>();
        MyStack<Character> operators = new MyStack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isDigit(c)) {
                output.push(Character.toString(c));

            } else if (isOperator(c)) {
                operators.push(c);

            } else if (isRightParenthesis(c)) {
                String leftParen = Character.toString(getLeftParen(c));
                String rightOperand = output.pop();
                String operator = Character.toString(operators.pop());
                String leftOperand = output.pop();
                String rightParen = Character.toString(c);

                String operation = leftParen.concat(leftOperand).concat(operator).concat(rightOperand).concat(rightParen);

                output.push(operation);
            }
        }

        return output.pop();

    }

    private static boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static boolean isRightParenthesis(char c) {
        return c == ')';
    }

    private static char getLeftParen(char rightParen) {
        switch (rightParen) {
            case ')':
                return '(';
            default:
                return ' ';
        }
    }
}
