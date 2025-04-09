package com.csc3104lab.csc3104lab.Lab2;



import java.util.Stack;

public class stackCoding2 {

    public static void postFixEvaluation(String equation) {
        Stack<Integer> stack = new Stack<Integer>();
        for(char i : equation.toCharArray()) {
            if(Character.isDigit(i)) {
                int value = Character.getNumericValue(i);
                stack.push(value);
                System.out.println("Push: " + value);
            }
            else {
                int y = stack.pop();
                System.out.println("Pop: " + y);
                int x = stack.pop();
                System.out.println("Pop: " + x);

                int result = 0;
                switch(i) {
                    case '+':
                        result = x + y;
                        break;
                    case '-':
                        result = x - y;
                        break;
                    case '*':
                        result = x * y;
                        break;
                    case '/':
                        result = x + y;
                        break;
                    default:
                        System.out.println("Invalid operator: " + i);
                }
                stack.push(result);
                System.out.println("Push: " + result);
            }
        }
    }
    public static void main(String[] args) {
        String equation1 = "723*+";
        String equation2 = "82+32*-";
        System.out.println("Evaluating expression: " + equation1);
        postFixEvaluation(equation1);
        System.out.println("\nEvaluating expression: " + equation2);
        postFixEvaluation(equation2);
    }
}