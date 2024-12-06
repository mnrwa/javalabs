package ru.bahanov.pracJava.task9;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class A {
    private static final double MAX_VALUE = Double.MAX_VALUE;

    public void main(String[] args) {
        String filePath = "D:\\prac\\prac1\\src\\main\\java\\ru\\bahanov\\pracJava\\task9\\data.txt";
        List<Double> numbers = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (String line : lines) {
                try {
                    String[] parts = line.split(";");
                    if (parts.length != 2) {
                        throw new InvalidFileContentException("Некорректный формат строки: " + line);
                    }

                    String locale = parts[0].trim();
                    String numberStr = parts[1].trim();

                    Locale numberLocale = Locale.forLanguageTag(locale.replace('_', '-'));
                    double number = parseNumber(numberStr, numberLocale);

                    if (number > MAX_VALUE) {
                        throw new InvalidNumberException("Число превышает допустимое значение: " + number);
                    }

                    numbers.add(number);
                } catch (InvalidFileContentException | InvalidNumberException e) {
                    System.err.println("Ошибка обработки строки: " + e.getMessage());
                }
            }

            double sum = numbers.stream().mapToDouble(Double::doubleValue).sum();
            double average = numbers.isEmpty() ? 0 : sum / numbers.size();

            System.out.printf("Сумма: %.2f\nСреднее: %.2f\n", sum, average);
        } catch (OutOfMemoryError e) {
            System.err.println("Ошибка: недостаточно памяти для выполнения операции.");
        } catch (NoSuchFileException e) {
            System.err.println("Файл не найден: " + filePath);
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Неизвестная ошибка: " + e.getMessage());
        }
    }

    private double parseNumber(String numberStr, Locale locale) throws InvalidNumberException {
        try {
            return Double.parseDouble(numberStr.replace(',', '.'));
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("Невозможно преобразовать строку в число: " + numberStr);
        }
    }

    class InvalidNumberException extends Exception {
        public InvalidNumberException(String message) {
            super(message);
        }
    }

    class InvalidFileContentException extends Exception {
        public InvalidFileContentException(String message) {
            super(message);
        }
    }

}
