package ru.bahanov.pracJava.task10.C;

import java.io.*;

public class C {

    public static void main(String[] args) {
        String filePath = "src/main/java/ru/bahanov/pracJava/task10/C/data.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\s+");

                for (String token : tokens) {
                    if (token.length() == 1 && Character.isLetterOrDigit(token.charAt(0))) {
                        System.out.println("Symbol: " + token);
                    } else if (token.matches("[a-zA-Zа-яА-Я]+")) {
                        System.out.println("Word: " + token);
                    } else {
                        try {
                            Integer.parseInt(token);
                            System.out.println("Integer: " + token);
                        } catch (NumberFormatException e1) {
                            try {
                                Float.parseFloat(token);
                                System.out.println("Float: " + token);
                            } catch (NumberFormatException e2) {
                            }
                        }
                    }
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
