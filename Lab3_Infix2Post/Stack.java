package Lab3_Infix2Post;

import java.util.Scanner;

public class Stack {
    private int MaxSize;
    private int top;
    private String[] stack;
    
    public Stack(int size) {
        MaxSize = size;
        stack = new String[size];
        top = -1;
    }

    public void push(String value) {
        if (top < MaxSize - 1) {
            stack[++top] = value;
        } else {
            System.out.println("Stack Overflow! Unable to push " + value);
        }
    }

    public String pop() {
        if (top >= 0) {
            return stack[top--];
        } else {
            System.out.println("The stack is empty.");
            return null;
        }
    }

    public String peek() {
        if (top >= 0) {
            return stack[top];
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == MaxSize - 1;
    }

    private int precedence(String operator) {
        switch (operator) {
            case "+": case "-": return 1;
            case "*": case "/": return 2;
            default: return 0;
        }
    }

    public String infixToPostfix(String infix) {
        String output = "";
        for (int i = 0; i < infix.length(); i++) {
            char currentChar = infix.charAt(i);
            String currentCharStr = String.valueOf(currentChar);

            if (Character.isDigit(currentChar)) {
                output +=currentChar;
            } else if (currentChar == ' ') {
                continue;
            } else if (currentChar == '(') {
                push(currentCharStr);
            } else if (currentChar == ')') {
                while (!isEmpty() && !peek().equals("(")) {
                    output += pop();
                }
                pop();
            } else { 
                while (!isEmpty() && precedence(peek()) >= precedence(currentCharStr)) {
                    output += pop();
                }
                push(currentCharStr);
            }
        }

        
        while (!isEmpty()) {
            output += pop();
        }

        return output.toString();
    }
    //make code for eval

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the infix expression: ");
        String input = scan.nextLine();
        
        Stack stk = new Stack(input.length());
        
        
        String postfix = stk.infixToPostfix(input);
        System.out.println("Postfix notation: " + postfix);
        
        
        scan.close();
    }
}
