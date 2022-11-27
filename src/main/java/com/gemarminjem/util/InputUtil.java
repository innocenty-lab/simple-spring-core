package com.gemarminjem.util;

import java.util.Scanner;

public class InputUtil {
    public static Integer integerInput(String info) {
        System.out.print(info + ": ");
        Scanner scanner = new Scanner(System.in);
        Integer data = scanner.nextInt();
        return data;
    }

    public static String stringInput(String info) {
        System.out.print(info + ": ");
        Scanner scanner = new Scanner(System.in);
        String data = scanner.next();
        return data;
    }
}
