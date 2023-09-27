package org.example._0915;

public class Main {

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(fibonacci(5));
    }

    public static long factorial(int number) {
        switch (number) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return number * factorial(number - 1);
        }
    }

    public static long fibonacci(int number) {
        switch (number) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            default:
                return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }
}