package com.csc3104lab.csc3104lab.Lab2;


import java.util.Stack;

public class stackCoding {

    public static void pushStack(Stack<Character> name, String fullName) {
        for(int i = 0; i < fullName.length(); i++) {
            char n = fullName.charAt(i);
            name.add(n);
            System.out.println(n);
        }
    }
    public static void peekStack(Stack<Character> name, String fullName) {
        System.out.println("\nCharacter on top at the stackk: \n" + name.peek());
        System.out.println("\nSize of the stackk: \n" + name.size() + "\n");
    }
    public static void popStack(Stack<Character> name, String fullName) {
        for(int i = 0; i < fullName.length(); i++) {
            char x = name.pop();
            System.out.println("\nPop value: \n" + x);
            System.out.println("Size of the stackk: \n" + name.size());
        }
    }
    public static void main(String[] args) {
        Stack<Character> name = new Stack<Character>();
        String fullName = "Alen Thiery Tom anak Collin";
        fullName = fullName.replaceAll(" ", "");
        pushStack(name, fullName);
        peekStack(name, fullName);
        popStack(name, fullName);
    }
}