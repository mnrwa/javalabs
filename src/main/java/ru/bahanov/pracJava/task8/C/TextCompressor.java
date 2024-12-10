package ru.bahanov.pracJava.task8.C;

public class TextCompressor {
    public static String compress(String input) {
        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 0; i < input.length(); i++) {
            if (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                count++;
            } else {
                compressed.append(input.charAt(i));
                if (count > 1) {
                    compressed.append(count);
                }
                count = 1;
            }
        }
        return compressed.toString();
    }

    public static String decompress(String input) {
        StringBuilder decompressed = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isLetter(currentChar)) {
                decompressed.append(currentChar);
            } else if (Character.isDigit(currentChar)) {
                int repeatCount = Character.getNumericValue(currentChar) - 1;
                for (int j = 0; j < repeatCount; j++) {
                    decompressed.append(decompressed.charAt(decompressed.length() - 1));
                }
            }
        }
        return decompressed.toString();
    }

    public static void main(String[] args) {
        String originalText = "hellowoooorld";
        String compressedText = compress(originalText);
        System.out.println("Сжатый текст: " + compressedText);

        String decompressedText = decompress(compressedText);
        System.out.println("Распакованный текст: " + decompressedText);
    }
}
