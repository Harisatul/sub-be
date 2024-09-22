package com.sub;

import java.util.Scanner;
import java.util.Stack;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //satu
        satu();

        //dua
        String input1 = "{{[<>[{{}}]]}}";
        System.out.println(dua(input1));

        String input2 = "[>]";
        System.out.println(dua(input2));

    }

    public static void satu(){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = scanner.nextLine();
        }

        boolean found = false;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (strings[i].equalsIgnoreCase(strings[j])) {
                    System.out.println((i + 1) + " " + (j + 1));
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        if (!found) {
            System.out.println("false");
        }
    }

    public static boolean dua(String input){
        if (input.length() < 1 || input.length() > 4096) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            switch (ch) {
                case '{':
                case '[':
                case '<':
                    stack.push(ch);
                    break;

                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '>':
                    if (stack.isEmpty() || stack.pop() != '<') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }

        return stack.isEmpty();
    }
    public static void tiga(){

    }

}
